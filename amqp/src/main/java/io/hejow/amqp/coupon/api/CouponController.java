package io.hejow.amqp.coupon.api;

import io.hejow.amqp.coupon.service.CouponService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coupons")
public class CouponController {
  private final CouponService couponService;

  public CouponController(CouponService couponService) {
    this.couponService = couponService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void create() {
    couponService.create();
  }

  @PostMapping("/{id}/use")
  @ResponseStatus(HttpStatus.OK)
  public void use(@PathVariable long id) {
    couponService.use(id);
  }
}
