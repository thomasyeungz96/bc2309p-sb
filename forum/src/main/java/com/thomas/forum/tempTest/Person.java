package com.thomas.forum.tempTest;

import java.util.Random;
import com.thomas.forum.tempTest.infra.WorldMoney;
import com.thomas.forum.tempTest.infra.MoneySelection;
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
        this.age = random.nextInt(22) + 18; // from 18 to 40
        // this.money = random.nextInt(99) + 1;
        this.money = random.nextInt(100); // from 0 to 100
    }

    public void grabMoney() {
        
        String name = this.getName().toUpperCase();
        int grabMoney = MoneySelection.ZERO.getMoney();
        if (grabMoney < 0) {
            System.out.println("cannot nagative");
        } else if (!(WorldMoney.getPublicMoney() < grabMoney)) {
            WorldMoney.setPublicMoney(WorldMoney.getPublicMoney() - grabMoney);
            System.out.printf("%s Grabed %d\nWorld money balance: %d\n\n", name,
                    grabMoney, WorldMoney.getPublicMoney());
        } else {
            System.out.printf("%s cannot grab money\n", name);
        }
    }

}
