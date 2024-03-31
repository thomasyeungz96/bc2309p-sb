package com.thomas.forum.contoller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thomas.forum.dto.Coingecko.CoinsIdDTO;
import com.thomas.forum.dto.Coingecko.RoiDTO;
import com.thomas.forum.model.Coin;

public interface CoingeckoOperation {

  // List<String> getCoinsID();
  @GetMapping(value = "string-coinsid")
  String getStringCoinsID();

  @GetMapping(value = "coins-id")
  List<CoinsIdDTO> getCoinsId(); 

  @GetMapping(value = "/coins")
  List<Coin> getCoins();

  @GetMapping(value = "/coin")
  Coin getCoin(@RequestParam(value = "id") String id);

  @GetMapping(value = "/coins-with-roi")
  List<RoiDTO> getRoi();

}
