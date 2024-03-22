package com.thomas.forum.tempTest;

import com.thomas.forum.tempTest.World;
import com.thomas.forum.tempTest.infra.BankPublic;
import com.thomas.forum.tempTest.infra.MoneySelection;

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
        } else if (!(BankPublic.getPublicMoney() < grabMoney)) {
            BankPublic.setPublicMoney(BankPublic.getPublicMoney() - grabMoney);
            System.out.printf("%s Grabed %d\nWorld money balance: %d\n\n", name,
                    grabMoney, BankPublic.getPublicMoney());
        } else {
            System.out.printf("%s cannot grab money\n", name);
        }
    }
}
