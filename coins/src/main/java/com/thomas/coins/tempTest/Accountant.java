package com.thomas.coins.tempTest;

import com.thomas.coins.tempTest.World;
import com.thomas.coins.tempTest.infra.MoneySelection;
import com.thomas.coins.tempTest.infra.WorldMoney;

public class Accountant extends Person {

    Accountant(String name) {
        super(name);
    }

    @Override
    public void grabMoney() {

        String name = this.getName().toUpperCase();
        int grabMoney = MoneySelection.FIVE_HUNDRED.getMoney();
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
