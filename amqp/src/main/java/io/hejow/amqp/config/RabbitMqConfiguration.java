package io.hejow.amqp.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.ConditionalRejectingErrorHandler;
import org.springframework.amqp.rabbit.listener.FatalExceptionStrategy;
import org.springframework.amqp.rabbit.listener.api.RabbitListenerErrorHandler;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class RabbitMqConfiguration {
  private static final Logger log = LoggerFactory.getLogger(RabbitMqConfiguration.class);

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
  public RabbitListenerConfigurer rabbitListenerConfigurer(LocalValidatorFactoryBean validator) {
    return registrar -> registrar.setValidator(validator);
  }

  @Bean
  public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(CachingConnectionFactory cachingConnectionFactory) {
    var containerFactory = new SimpleRabbitListenerContainerFactory();
    containerFactory.setConnectionFactory(cachingConnectionFactory);
//    containerFactory.setDefaultRequeueRejected(false);
    containerFactory.setMessageConverter(jackson2JsonMessageConverter());
//    containerFactory.setErrorHandler(t -> log.info(t.getCause().toString()));
    containerFactory.setErrorHandler(new ConditionalRejectingErrorHandler(new CustomExceptionStrategy()));
    return containerFactory;
  }

  @Bean
  public RabbitTemplate rabbitTemplate(ConnectionFactory cachingConnectionFactory) {
    var rabbitTemplate = new RabbitTemplate(cachingConnectionFactory);
    rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter());
    return rabbitTemplate;
  }

  @Bean
  public RabbitListenerErrorHandler customErrorHandler() {
    return (message, message1, e) -> {
      log.info(e.getCause().toString());
      return null;
    };
  }

  public static class CustomExceptionStrategy implements FatalExceptionStrategy {
    private final FatalExceptionStrategy fatalExceptionStrategy = new ConditionalRejectingErrorHandler.DefaultExceptionStrategy();

    @Override
    public boolean isFatal(Throwable throwable) {
      return fatalExceptionStrategy.isFatal(throwable) || throwable.getCause() instanceof IllegalArgumentException;
    }
  }
}
