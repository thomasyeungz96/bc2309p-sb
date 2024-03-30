package com.thomas.forum.contoller.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.RestController;
import com.thomas.forum.contoller.CoingeckoOperation;
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

  @Override
  public List<Coin> getCoins() {
    List<Coin> coins = coinService.getCoins();
    return coins;
  }

  @Override
  public List<RoiDTO> getRoi() {
    List<RoiDTO> coins = coinService.getCoins().stream()
        .filter(e -> e.getRoi() != null)
        .map(e -> {
            Coin coinDTO = new Coin(); 
            RoiDTO roiDTO = RoiDTO.builder()
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

