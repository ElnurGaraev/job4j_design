package ru.job4j.ood.lsp;

import java.time.LocalDate;

public class Warehouse extends AbstractStore {
    DateControl dateControl = new DateControl();
    LocalDate controlDate;

    public Warehouse(LocalDate controlDate) {
        this.dateControl = dateControl;
        this.controlDate = controlDate;
    }

    @Override
    public boolean isFresh(Food food) {
        return dateControl.spendDate(food.getCreateDate(), food.getExpiryDate(), controlDate) >= 75;
    }

    public LocalDate setDataControl(LocalDate controlDate) {
        return controlDate;
    }

    @Override
    public void setDateControl(LocalDate dateControl) {
        this.controlDate = dateControl;
    }
}
