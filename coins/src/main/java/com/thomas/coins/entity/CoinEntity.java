package com.thomas.coins.entity;

import java.io.Serializable;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.thomas.coins.model.Coin.Roi;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "coins")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CoinEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String idName;

  private String symbol;

  private String name;

  private String image;

  @Column(name = "current_price")
  private Long currentPrice;

  @Column(name = "market_cap")
  private Long marketCap;

  @Column(name = "market_cap_rank")
  private int marketCapRank;

  @Column(name = "fully_diluted_valuation")
  private Long fullyDilutedValuation;

  @Column(name = "total_volume")
  private Long totalVolume;

  @Column(name = "high_24h")
  private Long high24h;

  @Column(name = "low_24h")
  private Long low24h;

  @Column(name = "price_change_24h")
  private Double priceChange24h;

  @Column(name = "price_change_percentage_24h")
  private Double priceChangePercentage24h;

  @Column(name = "market_cap_change_24h")
  private Double marketCapChange24h;

  @Column(name = "market_cap_change_percentage_24h")
  private Double marketCapChangePercentage24h;

  @Column(name = "circulating_supply")
  private Double circulatingSupply;

  @Column(name = "total_supply")
  private Double totalSupply;

  @Column(name = "max_supply")
  private Double maxSupply;
  private Double ath;

  @Column(name = "ath_change_percentage")
  private Double athChangePercentage;

  @Column(name = "ath_date")
  private String athDate;

  private Double atl;

  @Column(name = "atl_change_percentage")
  private Double atlChangePercentage;

  @Column(name = "atl_date")
  private String atlDate;

  @Column(name = "Roi_Times")
  private Double roiTimes;

  @Column(name = "Roi_Currency")
  private String roiCurrency;

  @Column(name = "Roi_Percentage")
  private Double roiPercentage;

  @Column(name = "last_updated")
  private String lastUpdated;


}
