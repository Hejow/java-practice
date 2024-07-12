package io.hejow.amqp.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static io.hejow.amqp.config.MessageQueueProperties.COUPON_KEY;
import static io.hejow.amqp.config.MessageQueueProperties.DIRECT_KEY;

@Configuration
public class BindingConfiguration {

  @Bean
  public Binding couponBinding(
    @Qualifier("couponQueue") Queue queue,
    @Qualifier("couponExchange") DirectExchange exchange
  ) {
    return BindingBuilder.bind(queue).to(exchange).with(COUPON_KEY);
  }

  @Bean
  public Binding deadLetterBinding(
    @Qualifier("deadLetterQueue") Queue queue,
    @Qualifier("deadLetterExchange") FanoutExchange exchange
  ) {
    return BindingBuilder.bind(queue).to(exchange);
  }

  @Bean
  public Binding directBinding(
    @Qualifier("directQueue") Queue queue,
    @Qualifier("directExchange") DirectExchange exchange
  ) {
    return BindingBuilder.bind(queue).to(exchange).with(DIRECT_KEY);
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
}
