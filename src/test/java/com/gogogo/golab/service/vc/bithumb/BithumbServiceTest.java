package com.gogogo.golab.service.vc.bithumb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class BithumbServiceTest {

  @Autowired
  private BithumbService bithumbService;
  @Autowired
  private ObjectMapper objectMapper;

  @Test
  @DisplayName("Bithumb 캔들 조회")
  public void bithumb(){
    String uri = "/public/ticker/BTC_KRW";
    try {
      String response = bithumbService.getApi(uri).block();
      BithumbTicker bithumbTickers = objectMapper.readValue(response,new TypeReference<BithumbTicker>(){});
      log.info(">> {}", bithumbTickers);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
  }
}