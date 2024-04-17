package com.thomas.coins.tempTest;

import com.thomas.coins.model.Coin;

public class GenericTest<T> {

  T t;

  public static <T, R extends Coin> String methodA(R num) {

    new R(); 
    return "";
  }
}
