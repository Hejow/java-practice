package io.hejow.amqp.async;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@EnableAsync
@Configuration
public class AsyncConfiguration {

  @Bean("firstExecutor")
  public Executor firstExecutor() {
    var executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(3);
    executor.setMaxPoolSize(10);
    executor.setQueueCapacity(30);
    executor.setThreadNamePrefix("FIRST-");
    executor.initialize();
    return executor;
  }

  @Bean("secondExecutor")
  public Executor secondExecutor() {
    var executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(3);
    executor.setMaxPoolSize(10);
    executor.setQueueCapacity(30);
    executor.setThreadNamePrefix("SECOND-");
    executor.initialize();
    return executor;
  }
}
