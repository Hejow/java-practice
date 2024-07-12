package io.hejow.amqp.config;

import org.springframework.amqp.rabbit.config.RetryInterceptorBuilder;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.retry.RejectAndDontRequeueRecoverer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class RabbitMqConfiguration {
  private final RabbitProperties rabbitProperties;

  public RabbitMqConfiguration(RabbitProperties rabbitProperties) {
    this.rabbitProperties = rabbitProperties;
  }

  @Bean
  public MessageConverter jackson2JsonMessageConverter() {
    return new Jackson2JsonMessageConverter();
  }

  @Bean
  public CachingConnectionFactory cachingConnectionFactory() {
    var connectionFactory = new CachingConnectionFactory(rabbitProperties.getHost());
    connectionFactory.setUsername(rabbitProperties.getUsername());
    connectionFactory.setPassword(rabbitProperties.getPassword());
    return connectionFactory;
  }

  @Bean
  public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(CachingConnectionFactory cachingConnectionFactory) {
    var containerFactory = new SimpleRabbitListenerContainerFactory();
    containerFactory.setConnectionFactory(cachingConnectionFactory);
    containerFactory.setMessageConverter(jackson2JsonMessageConverter());

    containerFactory.setAdviceChain(
      RetryInterceptorBuilder.stateless()
        .maxAttempts(3)
        .backOffOptions(Duration.ofSeconds(3L).toMillis(), 2, Duration.ofSeconds(10L).toMillis())
        .recoverer(new RejectAndDontRequeueRecoverer())
        .build()
    );

    return containerFactory;
  }

  @Bean
  public RabbitTemplate rabbitTemplate(ConnectionFactory cachingConnectionFactory) {
    var rabbitTemplate = new RabbitTemplate(cachingConnectionFactory);
    rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter());
    return rabbitTemplate;
  }
}
