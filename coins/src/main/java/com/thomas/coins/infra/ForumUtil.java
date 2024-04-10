package com.thomas.coins.infra;

public class ForumUtil {


  public static int countDigits(double number) {
    String numberString = Double.toString(Math.abs(number)); // Convert to a string
    int length = numberString.length();
    return length;
  }

  public static int countDigits(int number) {
    String numberString = Integer.toString(Math.abs(number)); // Convert to a string
    int length = numberString.length();
    return length;
  }

  public static int countDigits(long number) {
    String numberString = Long.toString(Math.abs(number)); // Convert to a string
    int length = numberString.length();
    return length;
  }

  public static int compareMax(int num, int num2, int num3) {

    int max = -1;
    if (num > max)
      max = num;
    if (num2 > max)
      max = num2;
    if (num3 > max)
      max = num3;
    return max;
  }

  public static void printLine(int num) {
    for (int i = 0; i < num; i++) {
      System.out.print("-");
    }
    System.out.println();
  }

  
  
}
