package com.gogogo.golab.service.vc.bithumb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * https://apidocs.bithumb.com/docs/candlestick
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BithumbTicker {

  @JsonProperty("status")
  private String status;

  @JsonProperty("data")
  private CandleData data;

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @Builder
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonIgnoreProperties(ignoreUnknown = true)
  static class CandleData {
    @JsonProperty(value = "opening_price")
    private String openingPrice;

    @JsonProperty(value = "closing_price")
    private String closingPrice;

    @JsonProperty(value = "min_price")
    private String minPrice;

    @JsonProperty(value = "max_price")
    private String maxPrice;

    @JsonProperty(value = "units_traded")
    private String unitsTraded;

    @JsonProperty(value = "acc_trade_value")
    private String accTradeValue;

    @JsonProperty(value = "prev_closing_price")
    private String prevClosingPrice;

    @JsonProperty(value = "units_traded_24H")
    private String unitsTraded24H;

    @JsonProperty(value = "acc_trade_value_24H")
    private String accTradedValue24H;

    @JsonProperty(value = "fluctate_24H")
    private String fluctate24H;

    @JsonProperty(value = "fluctate_rate_24H")
    private String fluctateRate24H;
  }
}
