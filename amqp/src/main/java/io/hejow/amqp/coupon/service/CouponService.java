package io.hejow.amqp.coupon.service;

import io.hejow.amqp.coupon.domain.Coupon;
import io.hejow.amqp.coupon.domain.CouponRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CouponService {
  private static final Logger log = LoggerFactory.getLogger(CouponService.class);

  private final CouponMessageSender couponMessageSender;
  private final CouponRepository couponRepository;

  public CouponService(CouponMessageSender couponMessageSender, CouponRepository couponRepository) {
    this.couponMessageSender = couponMessageSender;
    this.couponRepository = couponRepository;
  }

  public void create() {
    var saved = couponRepository.save(new Coupon());

    log.info("Coupon issued : {}", saved.getId());
  }

  public void use(long id) {
    var coupon = couponRepository.findById(id)
      .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 쿠폰입니다. id : " + id));

    couponMessageSender.send(new CouponMessage(coupon.getId()));
    
    log.info("Use requested : {}", coupon.getId());
  }
}
