package io.hejow.amqp.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static io.hejow.amqp.config.MessageQueueProperties.COUPON_QUEUE;
import static io.hejow.amqp.config.MessageQueueProperties.DEAD_MESSAGE_EXCHANGE;
import static io.hejow.amqp.config.MessageQueueProperties.DEAD_MESSAGE_QUEUE;
import static io.hejow.amqp.config.MessageQueueProperties.DIRECT_QUEUE;
import static io.hejow.amqp.config.MessageQueueProperties.FANOUT_QUEUE;
import static io.hejow.amqp.config.MessageQueueProperties.FANOUT_QUEUE2;

@Configuration
public class QueueConfiguration {

  @Bean
  public Queue couponQueue() {
    return QueueBuilder.durable(COUPON_QUEUE)
      .deadLetterExchange(DEAD_MESSAGE_EXCHANGE)
      .build();
  }

  @Bean
  public Queue deadLetterQueue() {
    return QueueBuilder.durable(DEAD_MESSAGE_QUEUE).build();
  }

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
}
