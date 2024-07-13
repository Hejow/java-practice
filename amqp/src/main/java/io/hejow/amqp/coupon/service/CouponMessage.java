package io.hejow.amqp.coupon.service;

import jakarta.validation.constraints.NotNull;

public record CouponMessage(
  @NotNull Long id
) {
}
