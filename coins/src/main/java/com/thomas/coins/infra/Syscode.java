package com.thomas.coins.infra;

import org.springframework.beans.factory.annotation.Autowired;

import com.thomas.coins.service.CoinService;
import com.thomas.coins.service.impl.CoinsServiceImpl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
public enum Syscode {

  OK("0001", "The API is fine", "URL"),
  NULLPOINTER("0002", "Null pointer"),
  NO_RESPONDED("404", "No Responded URL", "URL"),
  ;

  private String code;
  private String message;
  private String url;

  private Syscode(final String code, final String message) {
    this.code = code;
    this.message = message;
  }

  private Syscode(final String code, final String message, String url) {
    this.code = code;
    this.message = message;
    this.url = url;
  }

  public Syscode setUrl(String url) {
    this.url = url;
    return this;

  }

}
