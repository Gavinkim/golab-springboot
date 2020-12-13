package com.gogogo.golab.service.vc.upbit;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class UpbitServiceTest {
  @Autowired
  private UpbitService upbitService;
  @Autowired
  private ObjectMapper objectMapper;

  @Test
  @DisplayName("업비트 캔들조회")
  public void candles(){
    try {
      String uri = "/candles/minutes/1?market=KRW-BTC&count=10";
      String response = upbitService.getApi(uri).block();
      List<UpbitCandle> upbitCandles = objectMapper.readValue(response,new TypeReference<List<UpbitCandle>>(){});
      log.info(">> convert: {}", upbitCandles);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}