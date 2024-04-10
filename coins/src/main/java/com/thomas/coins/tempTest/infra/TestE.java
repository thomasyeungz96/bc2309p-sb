package com.thomas.coins.tempTest.infra;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TestE {

    public static void someMethod() {
        try {
            // Code that may throw an exception
            System.out.println("Before exception");
            // Simulating an exception
            int result = 10 / 0;
            System.out.println("After exception"); // This line will not be executed
        } catch (ArithmeticException e) {
            // Handling the exception
            System.out.println("An error occurred: " + e.getMessage());
            System.out.println("cannot / 0 OK?!");
        }
        System.out.println("Continuing execution testing");

        double x = 100.0;
        double y = 3.0;

        BigDecimal result2 = BigDecimal.valueOf(x).divide(BigDecimal.valueOf(y), 1, RoundingMode.HALF_UP);
        System.out.println(String.valueOf(x) + "/" + String.valueOf(y) + " = " + result2);

        // Program continues here
    }

    public static void main(String[] args) {
        someMethod();
    }

}
