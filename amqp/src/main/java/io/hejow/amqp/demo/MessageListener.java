package io.hejow.amqp.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import static io.hejow.amqp.config.MessageQueueProperties.DIRECT_QUEUE;
import static io.hejow.amqp.config.MessageQueueProperties.FANOUT_QUEUE;
import static io.hejow.amqp.config.MessageQueueProperties.FANOUT_QUEUE2;

@Service
public class MessageListener {
  private static final Logger log = LoggerFactory.getLogger(MessageListener.class);

  @RabbitListener(queues = DIRECT_QUEUE)
  public void onDirect(Message message) {
    log.info("Received direct message: {}, by : {}", message.content(), 1);
  }

  @RabbitListener(queues = DIRECT_QUEUE)
  public void onDirect2(Message message) {
    log.info("Received direct message: {}, by : {}", message.content(), 2);
  }

  @RabbitListener(queues = {FANOUT_QUEUE, FANOUT_QUEUE2})
  public void onFanout(Message message) {
    log.info("Received fanout message: {}", message.content());
  }
}
