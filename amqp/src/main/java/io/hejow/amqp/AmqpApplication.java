package io.hejow.amqp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@SpringBootApplication
public class AmqpApplication {
  public static void main(String[] args) {
    SpringApplication.run(AmqpApplication.class, args);
  }
}
