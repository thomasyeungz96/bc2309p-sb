package com.thomas.forum.tempTest;

import java.util.ArrayList;
import java.util.List;

public class World {

    public static int publicMoney = 1000;

    // public static int getPublicMoney() {
    // return publicMoney;
    // }

    public static void printLine(int num) {
        for (int n = 0; n < num; n++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();

        people.add(new Person("bb"));
        people.add(new Teacher("Thomas"));
        people.add(new Accountant("Sandra"));
        int loop = 2;

        int max = -1;
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
            
            if (numPrintName >= numPrintAge)
                max = numPrintName;
            max = numPrintAge;

            if (max < numPrintMoney)
                max = numPrintMoney;

            printLine(max);
            System.out.println(printName);
            System.out.println(printAge);
            System.out.println(printMoney);
            printLine(max);

        }

        for (int i = 0; i < loop; i++) {
            for (int j = 0; j < people.size(); j++) {
                people.get(j).grabMoney();
            }
        }

    }

}