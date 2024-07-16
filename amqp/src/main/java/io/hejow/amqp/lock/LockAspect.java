package io.hejow.amqp.lock;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LockAspect {
  private static final String REDISSON_LOCK_PREFIX = "LOCK:";

  private final AopTransactionManager transactionManager;
  private final RedissonClient redissonClient;

  public LockAspect(AopTransactionManager transactionManager, RedissonClient redissonClient) {
    this.transactionManager = transactionManager;
    this.redissonClient = redissonClient;
  }

  @Around("@annotation(io.hejow.amqp.lock.Lockable) && @annotation(lockable)")
  public Object lock(ProceedingJoinPoint joinPoint, Lockable lockable) throws Throwable {
    var key = REDISSON_LOCK_PREFIX + lockable.key() + joinPoint.getArgs()[0];
    var lock = redissonClient.getLock(key);

    try {
      var available = lock.tryLock(lockable.waitTime(), lockable.leaseTime(), lockable.timeUnit());

      if (!available) {
        return false;
      }

      return transactionManager.proceed(joinPoint);
    } finally {
      lock.unlock();
    }
  }
}
