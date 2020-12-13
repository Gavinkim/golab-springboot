package com.gogogo.golab.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;

@Configuration
public class BeanConfig {
  private final static int DEFAULT_TIMEOUT = 3000;

  @Value("${vc.upbit.base_url}")
  private String vcUpbitBaseUrl;

  @Value("${vc.bithumb.base_url}")
  private String vcBithumbBaseUrl;

  @Bean
  public RedisConnectionFactory redisConnectionFactory(
      @Value("${redis.host}") String host,
      @Value("${redis.port}") int port,
      @Value("${redis.password}") String password){
    RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
    config.setPort(port);
    config.setHostName(host);
    config.setPassword(password);
    LettuceClientConfiguration clientConfig = LettuceClientConfiguration.builder()
        .commandTimeout(Duration.ofMillis(DEFAULT_TIMEOUT))
        .build();
    return new LettuceConnectionFactory(config,clientConfig);
  }

  @Bean
  public RedisTemplate<String,Object> redisTemplate(@Qualifier("redisConnectionFactory")
      RedisConnectionFactory redisConnectionFactory){
    RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
    redisTemplate.setKeySerializer(new StringRedisSerializer());
    redisTemplate.setValueSerializer(new StringRedisSerializer());;

    redisTemplate.setHashKeySerializer(new StringRedisSerializer());
    redisTemplate.setHashValueSerializer(new StringRedisSerializer());
    redisTemplate.setConnectionFactory(redisConnectionFactory);
    return redisTemplate;
  }

  @Bean
  public ObjectMapper objectMapper(){
    return Jackson2ObjectMapperBuilder.json()
        .featuresToDisable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
        .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        .modules(new JavaTimeModule())
        .build();
  }

  @Bean
  public ClientHttpConnector clientHttpConnector(){
    TcpClient tcpClient = TcpClient.create()
        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS,DEFAULT_TIMEOUT)
        .doOnConnected(connection -> {
          connection.addHandlerLast(new ReadTimeoutHandler(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS))
              .addHandlerLast(new WriteTimeoutHandler(DEFAULT_TIMEOUT,TimeUnit.MILLISECONDS));
        });
    ClientHttpConnector connector = new ReactorClientHttpConnector(HttpClient.from(tcpClient));
    return connector;
  }

  @Bean
  public WebClient upbitWebClient(@Qualifier("clientHttpConnector") ClientHttpConnector clientHttpConnector){
    return WebClient.builder()
        .baseUrl(vcUpbitBaseUrl)
        .clientConnector(clientHttpConnector)
        .build();
  }

  @Bean
  public WebClient bithumbWebClient(@Qualifier("clientHttpConnector") ClientHttpConnector clientHttpConnector){
    return WebClient.builder()
        .baseUrl(vcBithumbBaseUrl)
        .clientConnector(clientHttpConnector)
        .build();
  }

  @PersistenceContext
  private EntityManager entityManager;

  @Bean
  public JPAQueryFactory jpaQueryFactory(){
    return new JPAQueryFactory(entityManager);
  }
}
