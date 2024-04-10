package com.thomas.coins.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table 
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RoiEntity {

    @Id
    private Long id;
    private Double times; 
    private String currency;
    private Double percentage;

}
