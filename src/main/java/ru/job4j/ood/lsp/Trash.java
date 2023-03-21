package ru.job4j.ood.lsp;

import java.time.LocalDate;

public class Trash extends AbstractStore {
    DateControl dateControl = new DateControl();
    LocalDate controlDate;

    public Trash(LocalDate controlDate) {
        this.dateControl = dateControl;
        this.controlDate = controlDate;
    }

    @Override
    public boolean isFresh(Food food) {
        return dateControl.spendDate(food.getCreateDate(), food.getExpiryDate(), controlDate) <= 0;
    }

    @Override
    public void setDateControl(LocalDate dateControl) {
        this.controlDate = dateControl;
    }
}