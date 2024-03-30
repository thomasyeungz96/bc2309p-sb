package com.thomas.forum.model;

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
public class Coin {


  private String id;
  private String symbol;
  private String name;
  private String image;
  private long current_price;
  private long market_cap;
  private long market_cap_rank;
  private long fully_diluted_valuation;
  private long total_volume;
  private long high_24h;
  private long low_24h;
  private double price_change_24h;
  private double price_change_percentage_24h;
  private double market_cap_change_24h;
  private double market_cap_change_percentage_24h;
  private double circulating_supply;
  private double total_supply;
  private double max_supply;
  private long ath;
  private double ath_change_percentage;
  private String ath_date;
  private double atl;
  private double atl_change_percentage;
  private String atl_date;
  private Roi roi;
  private String last_updated;


  @Getter
  @Builder
  @ToString
  public static class Roi {

    private double times;
    private String currency;
    private double percentage;

  }


}
