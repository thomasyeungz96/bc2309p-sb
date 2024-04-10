package com.thomas.coins.tempTest.infra;

import com.fasterxml.jackson.databind.ser.std.NumberSerializer;

public enum MoneySelection {

  ZERO(0), ONE_HUNDRED(100), FIVE_HUNDRED(500), ONE_THOUSAND(1000);

  private int money;

  private MoneySelection() {

  }

  private MoneySelection(int money) {

    this.money = money;

  }

  public int getMoney() {
    return this.money;
  }

  public int getMoneyper(int sum) {
    return this.money * sum;
  }

}
