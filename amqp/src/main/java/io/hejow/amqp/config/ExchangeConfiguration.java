package io.hejow.amqp.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static io.hejow.amqp.config.MessageQueueProperties.COUPON_EXCHANGE;
import static io.hejow.amqp.config.MessageQueueProperties.DEAD_MESSAGE_EXCHANGE;
import static io.hejow.amqp.config.MessageQueueProperties.DIRECT_EXCHANGE;
import static io.hejow.amqp.config.MessageQueueProperties.FANOUT_EXCHANGE;

@Configuration
public class ExchangeConfiguration {

  @Bean
  public DirectExchange couponExchange() {
    return new DirectExchange(COUPON_EXCHANGE);
  }

  @Bean
  public FanoutExchange deadLetterExchange() {
    return ExchangeBuilder.fanoutExchange(DEAD_MESSAGE_EXCHANGE).build();
  }

  @Bean
  public DirectExchange directExchange() {
    return new DirectExchange(DIRECT_EXCHANGE);
  }

  @Bean
  public FanoutExchange fanoutExchange() {
    return new FanoutExchange(FANOUT_EXCHANGE);
  }
}
