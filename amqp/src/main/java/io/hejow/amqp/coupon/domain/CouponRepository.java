package io.hejow.amqp.coupon.domain;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class CouponRepository {
  private static final Map<Long, Coupon> database = new ConcurrentHashMap<>();

  private static long index = 1L;

  public Coupon save(Coupon coupon) {
    coupon.setId(index);
    database.put(index++, coupon);
    return coupon;
  }

  public Optional<Coupon> findById(Long id) {
    return Optional.ofNullable(database.get(id));
  }
}
