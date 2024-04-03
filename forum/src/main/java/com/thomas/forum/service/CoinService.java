package com.thomas.forum.service;
import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Service;
import com.thomas.forum.model.Coin;



public interface CoinService {



  // public String getCoins() throws IOException, InterruptedException;
  List<Coin> getCoins();

  


}
