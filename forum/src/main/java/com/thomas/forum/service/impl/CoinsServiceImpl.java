package com.thomas.forum.service.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.thomas.forum.infra.ForumUtil;
import com.thomas.forum.infra.Schema;
import com.thomas.forum.model.Coin;
import com.thomas.forum.service.CoinService;

@Service
public class CoinsServiceImpl implements CoinService {

  @Value("${server.api.digital_coin.domain}")
  private String domin;

  @Value("${server.api.digital_coin.domain.endpoints.coins}")
  private String userUri;

  public String url = UriComponentsBuilder.newInstance()
  .scheme(Schema.HTTPS.name().toLowerCase())
  .host(domin)
  .path(userUri)
  .toUriString();


  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<Coin> getCoins() {

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
    System.out.println(coinService.url);

    // List<Coin> coins = coinService.getCoins();

    // for (Coin coin : coins) {

    // if (coin.getRoi() != null) {

    // int numCountTimes = ForumUtil.countDigits(coin.getRoi().getTimes());
    // int numCountCurrency = coin.getRoi().getCurrency().length();
    // int numCountPercentage =
    // ForumUtil.countDigits(coin.getRoi().getPercentage());

    // int maxNum = ForumUtil.compareMax(numCountTimes, numCountCurrency,
    // numCountPercentage);

    // ForumUtil.printLine(maxNum);
    // System.out.println("Coin: " + coin.getName());
    // System.out.println("Roi-Times: " + coin.getRoi().getTimes());
    // System.out.println("Roi-Currency: " + coin.getRoi().getCurrency());
    // System.out.println("Roi-Percentage: " + coin.getRoi().getPercentage());
    // ForumUtil.printLine(maxNum);
    // }
    // }
  }

}
