package com.thomas.forum.contoller.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.annotation.JsonValueInstantiator;
import com.thomas.forum.contoller.CoingeckoOperation;
import com.thomas.forum.dto.Coingecko.CoinsIdDTO;
import com.thomas.forum.dto.Coingecko.RoiDTO;
import com.thomas.forum.dto.Coingecko.RoiDTO.RoiDTOBuilder;
import com.thomas.forum.dto.gov.UserDTO;
import com.thomas.forum.model.Coin;
import com.thomas.forum.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(value = "/coingecko/api/v1")
public class CoingeckoOperationImpl implements CoingeckoOperation {

  @Autowired
  private CoinService coinService;

  // @Override
  // public List<String> getCoinsID() {
  // List<String> stringID = coinService.getCoins().stream()
  // .filter(c -> c.getId() != null)
  // .map(c -> c.getId())
  // .collect(Collectors.toList());
  // return stringID;
  // }

  @Override
  public String getStringCoinsID() {
    String stringID = coinService.getCoins().stream()
        .filter(c -> c.getId() != null)
        .map(c -> c.getId())
        .collect(Collectors.joining(", \n"));
    return stringID;
  }

  @Override
  public List<CoinsIdDTO> getCoinsId() {

    List<CoinsIdDTO> coinsIdDTOs = coinService.getCoins().stream()
        .filter(c -> c.getId() != null)
        .map(c -> {
          CoinsIdDTO coinsIdDTO = new CoinsIdDTO();
          coinsIdDTO.setId(c.getId());
          return coinsIdDTO;
        })
        .collect(Collectors.toList());

    return coinsIdDTOs;

  }

  @Override
  public List<Coin> getCoins() {
    List<Coin> coins = coinService.getCoins();
    return coins;
  }

  @Override
  public Coin getCoin(String id) {

    // for the error message for showing the list of coins using DTO class
    List<CoinsIdDTO> coinsId = getCoinsId();
    List<String>  strs = new ArrayList<>();
    for (CoinsIdDTO coinsIdDTO : coinsId) {
      strs.add(coinsIdDTO.getId());
    } 


    Coin coin = coinService.getCoins().stream()
        .filter(c -> c.getId().equals(id))
        .findAny()
        .orElseThrow(() -> new RuntimeException("coin is not found and only support : " + strs));

    return coin;

  }

  @Override
  public List<RoiDTO> getRoi() {
    List<RoiDTO> coins = coinService.getCoins().stream()
        .filter(e -> e.getRoi() != null)
        .map(e -> {
          RoiDTO roiDTO = RoiDTO.builder()
              .id(e.getId())
              .name(e.getName())
              .image(e.getImage())
              .roi(e.getRoi()).build();
          return roiDTO;
        })
        .collect(Collectors.toList());

    return coins;

  }

  // @Override
  // public String getCoins() {

  // String coins = null;

  // try {
  // coins = coinService.getCoins();
  // } catch (IOException e) {
  // // TODO Auto-generated catch block
  // e.printStackTrace();
  // } catch (InterruptedException e) {
  // // TODO Auto-generated catch block
  // e.printStackTrace();
  // }

  // return coins;

  // }

}
