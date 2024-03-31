package com.thomas.forum.service.impl;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.thomas.forum.infra.ForumUtil;
import com.thomas.forum.model.Coin;
import com.thomas.forum.service.CoinService;

@Service
public class CoinsServiceImpl implements CoinService {


  @Value()

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<Coin> getCoins() {

    String url =
        // "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&ids=bitcoin%2C%20ethereum&locale=zh-tw&x_cg_demo_api_key=CG-1BuKWfyB3SqyjPYXtLpcQ83G";
        "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&x_cg_demo_api_key=CG-1BuKWfyB3SqyjPYXtLpcQ83G";

        https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&x_cg_demo_api_key=CG-1BuKWfyB3SqyjPYXtLpcQ83G

    Coin[] coins = restTemplate.getForObject(url, Coin[].class);

    List<Coin> coinsList = Arrays.asList(coins);

    return coinsList;

  }


  // public String getCoins() throws IOException, InterruptedException {

  // HttpRequest request = HttpRequest.newBuilder().uri(URI.create(
  // "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&ids=bitcoin%2C%20ethereum&locale=zh-tw&x_cg_demo_api_key=CG-1BuKWfyB3SqyjPYXtLpcQ83G"))
  // .method("GET", HttpRequest.BodyPublishers.noBody()).build();

  // HttpResponse<String> response = HttpClient.newHttpClient().send(request,
  // HttpResponse.BodyHandlers.ofString());

  // String body = response.body();

  // return body;

  // }

  

  public static void main(String[] args)
      throws IOException, InterruptedException {

    System.out.println("start");

    CoinsServiceImpl coinService = new CoinsServiceImpl();

    List<Coin> coins = coinService.getCoins();

    for (Coin coin : coins) {

      if (coin.getRoi() != null) {

        int numCountTimes = ForumUtil.countDigits(coin.getRoi().getTimes());
        int numCountCurrency = coin.getRoi().getCurrency().length();
        int numCountPercentage = ForumUtil.countDigits(coin.getRoi().getPercentage());

        int maxNum =
            ForumUtil.compareMax(numCountTimes, numCountCurrency, numCountPercentage);

        ForumUtil.printLine(maxNum);
        System.out.println("Coin: " + coin.getName());
        System.out.println("Roi-Times: "+coin.getRoi().getTimes());
        System.out.println("Roi-Currency: "+coin.getRoi().getCurrency());
        System.out.println("Roi-Percentage: "+coin.getRoi().getPercentage());
        ForumUtil.printLine(maxNum);
      }
    }
  }

}


