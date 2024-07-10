package io.hejow.amqp.controller;

import io.hejow.amqp.message.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static io.hejow.amqp.message.RabbitMqConfiguration.DIRECT_EXCHANGE;
import static io.hejow.amqp.message.RabbitMqConfiguration.DIRECT_KEY;
import static io.hejow.amqp.message.RabbitMqConfiguration.FANOUT_EXCHANGE;

@RestController
public class MessageController {
  private final RabbitTemplate rabbitTemplate;

  public MessageController(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  @PostMapping("/messages/direct")
  @ResponseStatus(HttpStatus.CREATED)
  public void direct(@RequestBody Message message) {
    rabbitTemplate.convertAndSend(DIRECT_EXCHANGE, DIRECT_KEY, message);
  }

  @PostMapping("/messages/fanout")
  @ResponseStatus(HttpStatus.CREATED)
  public void fanout(@RequestBody Message message) {
    rabbitTemplate.convertAndSend(FANOUT_EXCHANGE, "", message);
  }
}
