package com.thomas.coins.dto.Coingecko;

import com.thomas.coins.model.Coin.Roi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class RoiDTO {

  private String id;
  private String name;
  private String image;
  private Roi roi;


}


