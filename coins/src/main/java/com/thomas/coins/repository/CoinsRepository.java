package com.thomas.coins.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thomas.coins.entity.CoinEntity;

@Repository
public interface CoinsRepository extends JpaRepository<CoinEntity, Long> {

}
