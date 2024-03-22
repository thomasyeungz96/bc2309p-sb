package com.thomas.forum.tempTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.thomas.forum.tempTest.infra.SystemRandom;

public class World {

    public static void printLine(int num) {
        for (int n = 0; n < num; n++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printUsersStatus(List<Person> people) {

        int max;
        int numPrintName;
        int numPrintAge;
        int numPrintMoney;

        for (int i = 0; i < people.size(); i++) {

            String printName = "User name : " + people.get(i).getName();
            String printAge = "User age : " + people.get(i).getAge();
            String printMoney = "User money : " + people.get(i).getMoney();
            numPrintName = printName.length();
            numPrintAge = printAge.length();
            numPrintMoney = printMoney.length();
            max = -1;

            if (numPrintName >= numPrintAge) {
                max = numPrintName;
            } else {
                max = numPrintAge;
            }

            if (max < numPrintMoney)
                max = numPrintMoney;

            printLine(max);
            System.out.println(printName);
            System.out.println(printAge);
            System.out.println(printMoney);
            printLine(max);

        }

    }

    public static void loopGrabeMoney(int loop, List<Person> people) {
        for (int i = 0; i < loop; i++) {
            for (int j = 0; j < people.size(); j++) {
                people.get(j).grabMoney();
            }
        }
    }

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();

        people.add(new Person("bb"));
        people.add(new Teacher("Daisy"));
        people.add(new Accountant("Thomas"));

        int loop = SystemRandom.fromOneto(10);

        printUsersStatus(people);

        World.loopGrabeMoney(loop, people);
        System.out.println("looped: " + loop);

    }

}
