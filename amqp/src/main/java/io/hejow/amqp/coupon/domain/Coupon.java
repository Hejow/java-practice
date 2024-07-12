package io.hejow.amqp.coupon.domain;

public class Coupon {
  private Long id;
  private boolean used;

  public Coupon() {
    this.used = false;
  }

  void setId(Long id) {
    this.id = id;
  }

  public void use() {
    if (this.used) {
      throw new IllegalStateException("이미 사용된 쿠폰입니다.");
    }

    this.used = true;
  }

  public Long getId() {
    return id;
  }
}
