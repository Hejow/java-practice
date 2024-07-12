package io.hejow.amqp.coupon.service;

public interface CouponMessageSender {
  void send(CouponMessage message);
}
