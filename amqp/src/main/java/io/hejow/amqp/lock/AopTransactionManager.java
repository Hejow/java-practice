package io.hejow.amqp.lock;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class AopTransactionManager {

  public Object proceed(ProceedingJoinPoint joinPoint) throws Throwable {
    return joinPoint.proceed();
  }
}
