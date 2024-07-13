package io.hejow.amqp.coupon.service;

import io.hejow.amqp.coupon.domain.CouponRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static io.hejow.amqp.config.MessageQueueProperties.COUPON_QUEUE;

@Component
@Transactional
public class CouponListener {
  private static final Logger log = LoggerFactory.getLogger(CouponListener.class);

  private final CouponRepository couponRepository;

  public CouponListener(CouponRepository couponRepository) {
    this.couponRepository = couponRepository;
  }

  @RabbitListener(queues = COUPON_QUEUE, errorHandler = "customErrorHandler")
  public void onUse(CouponMessage couponMessage) {
    log.info("Received Using coupon Message ID : {}", couponMessage.id());

    var coupon = couponRepository.findById(couponMessage.id())
      .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 쿠폰입니다. id : " + couponMessage.id()));

    coupon.use();
  }
}
