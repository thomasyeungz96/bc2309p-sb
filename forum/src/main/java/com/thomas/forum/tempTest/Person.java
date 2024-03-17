package com.thomas.forum.tempTest;

import java.util.Random;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Person {

    private String name;
    private int age;
    private int money;
    private Random random;

    // Person() {

    // Random random = new Random();
    // this.age = random.nextInt(99) + 1;
    // // this.money = random.nextInt(99) + 1;
    // this.money = 200;
    // }

    Person(String name) {

        Random random = new Random();
        this.name = name;
        this.age = random.nextInt(99) + 1;
        // this.money = random.nextInt(99) + 1;
        this.money = 200;
    }

    public void grabMoney() {

        // int worldMoney = World.publicMoney;

        int grabMoney = 0;

        String name = this.getName().toUpperCase();

        if (grabMoney < 0) {
            System.out.println("cannot nagative");
        } else if (!(World.publicMoney < grabMoney)) {
            World.publicMoney -= grabMoney;
            System.out.printf("%s Grabed %d\nWorld money balance: %d\n\n", name, grabMoney, World.publicMoney);
        } else {
            System.out.printf("%s cannot grab money\n", name);
        }
    }

}
