package io.hejow.amqp.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static io.hejow.amqp.config.MessageQueueProperties.DIRECT_EXCHANGE;
import static io.hejow.amqp.config.MessageQueueProperties.DIRECT_KEY;
import static io.hejow.amqp.config.MessageQueueProperties.DIRECT_QUEUE;
import static io.hejow.amqp.config.MessageQueueProperties.FANOUT_EXCHANGE;
import static io.hejow.amqp.config.MessageQueueProperties.FANOUT_QUEUE;
import static io.hejow.amqp.config.MessageQueueProperties.FANOUT_QUEUE2;

@Configuration
public class DemoRabbitConfiguration {

  @Bean
  public Queue directQueue() {
    return new Queue(DIRECT_QUEUE);
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
  public DirectExchange directExchange() {
    return new DirectExchange(DIRECT_EXCHANGE);
  }

  @Bean
  public FanoutExchange fanoutExchange() {
    return new FanoutExchange(FANOUT_EXCHANGE);
  }

  @Bean
  public Binding directBinding() {
    return BindingBuilder.bind(directQueue()).to(directExchange()).with(DIRECT_KEY);
  }

  @Bean
  public Binding fanoutBinding() {
    return BindingBuilder.bind(fanoutQueue()).to(fanoutExchange());
  }

  @Bean
  public Binding fanoutBinding2() {
    return BindingBuilder.bind(fanoutQueue2()).to(fanoutExchange());
  }
}
