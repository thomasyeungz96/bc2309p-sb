package com.thomas.coins.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Coin {

  private String id;

  private String symbol;

  private String name;

  private String image;

  // @JsonProperty("current_price")
  private Long currentPrice;

  // @JsonProperty("market_cap")
  private Long marketCap;

  // @JsonProperty("market_cap_rank")
  private int marketCapRank;

  // @JsonProperty("fully_diluted_valuation")
  private Long fullyDilutedValuation;

  // @JsonProperty("total_volume")
  private Long totalVolume;

  @JsonProperty("high_24h")
  private Long high24h;

  @JsonProperty("low_24h")
  private Long low24h;

  @JsonProperty("price_change_24h")
  private Double priceChange24h;

  @JsonProperty("price_change_percentage_24h")
  private Double priceChangePercentage24h;

  @JsonProperty("market_cap_change_24h")
  private Double marketCapChange24h;

  @JsonProperty("market_cap_change_percentage_24h")
  private Double marketCapChangePercentage24h;

  // @JsonProperty("circulating_supply")
  private Double circulatingSupply;

  // @JsonProperty("total_supply")
  private Double totalSupply;

  // @JsonProperty("max_supply")
  private Double maxSupply;
  
  private Double ath;

  // @JsonProperty("ath_change_percentage")
  private Double athChangePercentage;

  // @JsonProperty("ath_date")
  private String athDate;

  private Double atl;

  // @JsonProperty("atl_change_percentage")
  private Double atlChangePercentage;

  // @JsonProperty("atl_date")
  private String atlDate;

  private Roi roi;

  // @JsonProperty("last_updated")
  private String lastUpdated;

  @Getter
  @Builder
  @ToString
  public static class Roi {

    private Double times;
    private String currency;
    private Double percentage;

  }

}
