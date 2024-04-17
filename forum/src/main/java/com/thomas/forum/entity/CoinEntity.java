package com.thomas.forum.entity;

import java.io.Serializable;
import org.hibernate.engine.jdbc.SerializableBlobProxy;
import com.thomas.forum.model.Coin.Roi;
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
  private String symbol;
  private String name;
  private String image;
  private Long current_price;
  private Long market_cap;
  private Long market_cap_rank;
  private Long fully_diluted_valuation;
  private Long total_volume;
  private Long high_24h;
  private Long low_24h;
  private Double price_change_24h;
  private Double price_change_percentage_24h;
  private Double market_cap_change_24h;
  private Double market_cap_change_percentage_24h;
  private Double circulating_supply;
  private Double total_supply;
  private Double max_supply;
  private Long ath;
  private Double ath_change_percentage;
  private String ath_date;
  private Double atl;
  private Double atl_change_percentage;
  private String atl_date;
  private Roi roi;
  private String last_updated;


}
