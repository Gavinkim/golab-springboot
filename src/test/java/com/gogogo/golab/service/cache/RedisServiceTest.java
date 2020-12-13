package com.gogogo.golab.service.cache;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RedisServiceTest {
  @Autowired
  private RedisService redisService;

  @Test
  @DisplayName("레디스 테스트")
  public void redisTest(){
    redisService.save("sample","Value test");
  }
}