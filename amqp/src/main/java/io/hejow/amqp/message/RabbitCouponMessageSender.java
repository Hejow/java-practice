package io.hejow.amqp.message;

import io.hejow.amqp.coupon.service.CouponMessage;
import io.hejow.amqp.coupon.service.CouponMessageSender;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static io.hejow.amqp.config.MessageQueueProperties.COUPON_EXCHANGE;
import static io.hejow.amqp.config.MessageQueueProperties.COUPON_KEY;

@Component
@Transactional
class RabbitCouponMessageSender implements CouponMessageSender {
  private final RabbitTemplate rabbitTemplate;

  public RabbitCouponMessageSender(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  @Override
  public void send(CouponMessage message) {
    rabbitTemplate.convertAndSend(COUPON_EXCHANGE, COUPON_KEY, message);
  }
}
