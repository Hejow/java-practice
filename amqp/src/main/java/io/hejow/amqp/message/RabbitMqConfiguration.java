package io.hejow.amqp.message;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration {
  public static final String DIRECT_KEY = "direct-key";
  public static final String DIRECT_QUEUE = "direct-queue";
  public static final String DIRECT_EXCHANGE = "direct-exchange";

  public static final String FANOUT_QUEUE = "fanout-queue";
  public static final String FANOUT_QUEUE2 = "fanout-queue2";
  public static final String FANOUT_EXCHANGE = "fanout-exchange";

  private final RabbitProperties rabbitProperties;

  public RabbitMqConfiguration(RabbitProperties rabbitProperties) {
    this.rabbitProperties = rabbitProperties;
  }

  @Bean
  public Queue directQueue() {
    return new Queue(DIRECT_QUEUE);
  }

  @Bean
  public DirectExchange directExchange() {
    return new DirectExchange(DIRECT_EXCHANGE);
  }

  @Bean
  public Binding directBinding(
    @Qualifier("directQueue") Queue queue,
    @Qualifier("directExchange") DirectExchange exchange
  ) {
    return BindingBuilder.bind(queue).to(exchange).with(DIRECT_KEY);
  }

  @Bean
  public Queue fanoutQueue() {
    return new Queue(FANOUT_QUEUE);
  }

  @Bean
  public Queue fanoutQueue2() {
    return new Queue(FANOUT_QUEUE2);
  }

  @Bean
  public FanoutExchange fanoutExchange() {
    return new FanoutExchange(FANOUT_EXCHANGE);
  }

  @Bean
  public Binding fanoutBinding(
    @Qualifier("fanoutQueue") Queue queue,
    @Qualifier("fanoutExchange") FanoutExchange exchange
  ) {
    return BindingBuilder.bind(queue).to(exchange);
  }

  @Bean
  public Binding fanoutBinding2(
    @Qualifier("fanoutQueue2") Queue queue,
    @Qualifier("fanoutExchange") FanoutExchange exchange
  ) {
    return BindingBuilder.bind(queue).to(exchange);
  }

  @Bean
  public RabbitTemplate rabbitTemplate() {
    var connectionFactory = new CachingConnectionFactory(rabbitProperties.getHost());
    connectionFactory.setUsername(rabbitProperties.getUsername());
    connectionFactory.setPassword(rabbitProperties.getPassword());

    var rabbitTemplate = new RabbitTemplate(connectionFactory);
    rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter());
    return rabbitTemplate;
  }

  @Bean
  public MessageConverter jackson2JsonMessageConverter() {
    return new Jackson2JsonMessageConverter();
  }
}
