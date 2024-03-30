package com.thomas.forum.tempTest;

import com.thomas.forum.tempTest.World;
import com.thomas.forum.tempTest.infra.WorldMoney;
import com.thomas.forum.tempTest.infra.MoneySelection;

public class Teacher extends Person {

    Teacher(String name) {
        super(name);
    }

    @Override
    public void grabMoney() {

        String name = this.getName().toUpperCase();
        int grabMoney = MoneySelection.ONE_HUNDRED.getMoney();
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