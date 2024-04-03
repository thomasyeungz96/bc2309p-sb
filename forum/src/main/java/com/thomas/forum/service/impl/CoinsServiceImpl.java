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
import lombok.Getter;

@Service
public class CoinsServiceImpl implements CoinService {

  @Value("${api.digitalcoin.domain}")
  private String domin;

  @Value("${api.digitalcoin.endpoints.coins}")
  private String endpoints;

  @Value("${api.digitalcoin.endpoints.currency_key}")
  private String currencyKey;

  @Value("${api.digitalcoin.endpoints.currency_value}")
  private String currencyValue;

  @Value("${api.digitalcoin.endpoints.key_key}")
  private String key;

  @Value("${api.digitalcoin.endpoints.key_value}")
  private String keyValue;


  @SuppressWarnings("null")
  private String url = UriComponentsBuilder.newInstance()
      .scheme(Schema.HTTP.name().toLowerCase()).host(domin).path(endpoints)
      .queryParam(currencyKey, currencyValue).queryParam(key, keyValue)
      .toUriString();

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<Coin> getCoins() {

    url =
    "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&x_cg_demo_api_key=CG-1BuKWfyB3SqyjPYXtLpcQ83G";

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

}
