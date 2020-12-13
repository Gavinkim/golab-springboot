package com.gogogo.golab.service.vc.upbit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * https://docs.upbit.com/reference#분minute-캔들-1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpbitCandle {

  @JsonProperty(value = "market")
  private String market;

  @JsonProperty(value = "candle_date_time_utc")
  private String candleDatetimeUtc;

  @JsonProperty(value = "candle_date_time_kst")
  private String candleDatetimeKst;

  @JsonProperty(value = "opening_price")
  private double openingPrice; //시가

  @JsonProperty(value = "high_price")
  private double highPrice; //고가

  @JsonProperty(value = "low_price")
  private double lowPrice; //저가

  @JsonProperty(value = "trade_price")
  private double tradePrice; //종가

  @JsonProperty(value = "timestamp")
  private long timestamp;

  @JsonProperty(value = "candle_acc_trade_price")
  private double candleAccTradePrice; //누적거래 금액

  @JsonProperty(value = "candle_acc_trade_volume")
  private double candleAccTradeVolume; //누적 거래랭

  @JsonProperty(value = "unit")
  private int unit;
}
