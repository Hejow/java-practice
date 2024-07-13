package io.hejow.amqp.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static io.hejow.amqp.config.MessageQueueProperties.COUPON_DLX;
import static io.hejow.amqp.config.MessageQueueProperties.COUPON_EXCHANGE;
import static io.hejow.amqp.config.MessageQueueProperties.COUPON_KEY;
import static io.hejow.amqp.config.MessageQueueProperties.COUPON_QUEUE;

@Configuration
public class CouponRabbitConfiguration {

  @Bean
  public Queue couponQueue() {
    return QueueBuilder.durable(COUPON_QUEUE)
      .deadLetterExchange(COUPON_DLX)
      .build();
  }

  @Bean
  public DirectExchange couponExchange() {
    return new DirectExchange(COUPON_EXCHANGE);
  }

  @Bean
  public Binding couponBinding() {
    return BindingBuilder.bind(couponQueue()).to(couponExchange()).with(COUPON_KEY);
  }
}
