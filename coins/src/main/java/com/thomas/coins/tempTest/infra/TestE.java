package com.thomas.coins.tempTest.infra;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TestE {

    public static void methodA() {
        try {
            // Code that may throw an exception
            System.out.println("Before exception");
            // Simulating an exception
            int result = 10 / 0;
            System.out.println("After exception"); // This line will not be executed
        } catch (ArithmeticException e) {
            // Handling the exception
            System.out.println("An error occurred:" + e.getMessage());
            System.out.println("cannot / 0 OK?!");
        }
        System.out.println("Continuing execution testing");
    }

    public static double methodB() {

        double x = 100.0;
        double y = 3.0;

        try {
            int choose = 0;
            BigDecimal result;

            switch (choose) {
                case 1:
                    result = BigDecimal.valueOf(x).divide(BigDecimal.valueOf(y), 2,
                            RoundingMode.HALF_UP);
                    break;

                default:              
                    result = BigDecimal.valueOf(x).divide(BigDecimal.valueOf(y));
                    System.out.println("result2 = " + result);
                    break;

            }
            return result.doubleValue();

        } catch (Exception e) {
            double defaultValue = 0.0;

            System.out.println();
            System.out.println("MethodB's exception" + "\n" + "message= " + e.getMessage());
            System.out.println("default value will be: " + defaultValue);
            return defaultValue;
        }

    }

    public static void main(String[] args) {
        // methodA();
        System.out.println("main method print= " + methodB());

    }

}
