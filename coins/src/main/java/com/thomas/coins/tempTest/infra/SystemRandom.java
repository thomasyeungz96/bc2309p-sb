package com.thomas.coins.tempTest.infra;

import java.util.Random;


public class SystemRandom {

  public static int fromOneto(int num) {

    try {
      Random random = new Random();

      int randomNum = random.nextInt(num) + 1;

      return randomNum;

    } catch (IllegalArgumentException e) {

      System.out.println("wrong input");
      System.out.println("Invalid argument" + e.getMessage());

    }
    return -1;

  }


}

