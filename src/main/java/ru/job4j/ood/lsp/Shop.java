package ru.job4j.ood.lsp;

import java.time.LocalDate;

public class Shop extends AbstractStore {
    private DateControl calculatorDate = new DateControl();
    private LocalDate controlDate;

    public Shop(LocalDate controlDate) {
        this.controlDate = controlDate;
    }

    @Override
    public boolean isFresh(Food food) {
        boolean rsl = false;
        if (calculatorDate.spendDate(food.getCreateDate(), food.getExpiryDate(), controlDate) >= 25
                && calculatorDate.spendDate(food.getCreateDate(), food.getExpiryDate(), controlDate) <= 75) {
            rsl = true;
        } else if (calculatorDate.spendDate(food.getCreateDate(), food.getExpiryDate(), controlDate) < 25
                && calculatorDate.spendDate(food.getCreateDate(), food.getExpiryDate(), controlDate) > 0) {
            food.setDiscount(0.5F);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public void setDateControl(LocalDate dateControl) {
        this.controlDate = dateControl;
    }
}
