package io.hejow.amqp.like.service;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@TestConfiguration
public class HikariPoolConfig {

  @Bean
  public DataSource dataSource() {
    var hikariConfig = new HikariConfig();
    hikariConfig.setJdbcUrl("jdbc:h2:mem:testdb");
    hikariConfig.setUsername("sa");
    hikariConfig.setPassword("");
    hikariConfig.setMaximumPoolSize(11);

    return new HikariDataSource(hikariConfig);
  }
}
