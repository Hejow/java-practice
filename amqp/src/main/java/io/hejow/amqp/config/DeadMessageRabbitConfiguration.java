package io.hejow.amqp.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static io.hejow.amqp.config.MessageQueueProperties.COUPON_DLQ;
import static io.hejow.amqp.config.MessageQueueProperties.COUPON_DLX;

@Configuration
public class DeadMessageRabbitConfiguration {

  @Bean
  public Queue deadLetterQueue() {
    return QueueBuilder.durable(COUPON_DLQ).build();
  }

  @Bean
  public FanoutExchange deadLetterExchange() {
    return ExchangeBuilder.fanoutExchange(COUPON_DLX).build();
  }

  @Bean
  public Binding deadLetterBinding() {
    return BindingBuilder.bind(deadLetterQueue()).to(deadLetterExchange());
  }
}
