package com.thomas.forum.contoller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.thomas.forum.dto.Coingecko.RoiDTO;
import com.thomas.forum.model.Coin;


public interface CoingeckoOperation {

  @GetMapping(value = "/coins")
  List<Coin> getCoins();
  // String getCoins();

  @GetMapping(value = "/coins-roi")
  List<RoiDTO> getRoi();



}
