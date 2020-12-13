package com.gogogo.golab.service.cache;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gogogo.golab.utils.Utils;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisService {

  private final RedisTemplate redisTemplate;
  private final ObjectMapper objectMapper;

  public <T> boolean save(String key, T t, int expireTime, TimeUnit unit) {
    try {
      String json = objectMapper.writeValueAsString(t);
      redisTemplate.opsForValue().set(key, json);
      return redisTemplate.expire(key, expireTime, unit);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      log.error("{}", e.getMessage());
      return false;
    }
  }

  public <T> boolean save(String key, T t){
    try {
      String json = objectMapper.writeValueAsString(t);
      redisTemplate.opsForValue().set(key,json);
      return true;
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      log.error("{}",e.getMessage());
      return false;
    }
  }

  public boolean delete(String key) {
    return redisTemplate.delete(key);
  }

  public <T> Optional<T> get(String key, Class<T> classType){
    try {
      String json = (String) redisTemplate.opsForValue().get(key);
      if(Utils.isNotEmpty(json)){
        return Optional.ofNullable(objectMapper.readValue(json,classType));
      }
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      log.error("{}",e.getMessage());
    }
    return Optional.empty();
  }

}
