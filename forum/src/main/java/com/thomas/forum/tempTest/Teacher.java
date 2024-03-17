package com.thomas.forum.tempTest;

import com.thomas.forum.tempTest.World;

public class Teacher extends Person {

    Teacher(String name) {
        super(name);
    }

    @Override
    public void grabMoney() {

        int grabMoney = 100;

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