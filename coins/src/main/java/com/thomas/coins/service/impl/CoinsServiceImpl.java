package com.thomas.coins.service.impl;

import java.io.IOException;
import java.sql.Time;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.thomas.coins.entity.CoinEntity;
import com.thomas.coins.infra.ForumUtil;
import com.thomas.coins.infra.Schema;
import com.thomas.coins.model.Coin;
import com.thomas.coins.repository.CoinsRepository;
import com.thomas.coins.service.CoinService;
import com.thomas.coins.service.Times;

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

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private CoinsRepository coinsRepository;

  @Override
  public List<Coin> getCoins() throws RuntimeException {

    String url = UriComponentsBuilder.newInstance()
        .scheme(Schema.HTTPS.name().toLowerCase()).host(domin).path(endpoints)
        .queryParam(currencyKey, currencyValue).queryParam(key, keyValue)
        .toUriString();

    // url =
    // "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&x_cg_demo_api_key=CG-1BuKWfyB3SqyjPYXtLpcQ83G";

    Coin[] coins = restTemplate.getForObject(url, Coin[].class);

    List<Coin> coinsList = Arrays.asList(coins);

    List<CoinEntity> coinsEntities = coinsList.stream()
        .map(e -> {
          CoinEntity.CoinEntityBuilder builder = CoinEntity.builder();
          builder.idName(e.getId())
              .symbol(e.getSymbol())
              .name(e.getName())
              .image(e.getImage())
              .currentPrice(e.getCurrentPrice())
              .marketCap(e.getMarketCap())
              .marketCapRank(e.getMarketCapRank())
              .fullyDilutedValuation(e.getFullyDilutedValuation())
              .totalVolume(e.getTotalVolume())
              .high24h(e.getHigh24h())
              .low24h(e.getLow24h())
              .priceChange24h(e.getPriceChange24h())
              .priceChangePercentage24h(e.getPriceChangePercentage24h())
              .marketCapChange24h(e.getMarketCapChange24h())
              .marketCapChangePercentage24h(e.getMarketCapChangePercentage24h())
              .circulatingSupply(e.getCirculatingSupply())
              .totalSupply(e.getTotalSupply())
              .maxSupply(e.getMaxSupply())
              .ath(e.getAth())
              .athChangePercentage(e.getAthChangePercentage())
              .athDate(e.getAthDate())
              .atl(e.getAth())
              .atlChangePercentage(e.getAtlChangePercentage())
              .atlDate(e.getAtlDate())
              .lastUpdated(e.getLastUpdated());

          if (e.getRoi() != null) {
            builder.roiTimes(e.getRoi().getTimes());
            builder.roiCurrency(e.getRoi().getCurrency());
            builder.roiPercentage(e.getRoi().getPercentage());
          }

          return builder.build();

        })
        .collect(Collectors.toList());

    if (Times.count < 3) {
      coinsRepository.deleteAll();
      Times.count++;
    }
    coinsRepository.saveAll(coinsEntities);
    
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
