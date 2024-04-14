package com.thomas.coins.infra;

public enum Syscode {

  OK("0001", "The API is fine"), NULLPOINTER("0002", "Encounter Null pointer"),;

  private String code;
  private String message;

  private Syscode(String code, String message) {
    this.code = code;
    this.message = message;
  }
}
