package ru.job4j.ood.lsp;

import java.time.LocalDate;

public class Warehouse extends AbstractStore {
    private DateControl dateControl = new DateControl();
    private LocalDate controlDate;

    public Warehouse(LocalDate controlDate) {
        this.controlDate = controlDate;
    }

    @Override
    public boolean isFresh(Food food) {
        return dateControl.spendDate(food.getCreateDate(), food.getExpiryDate(), controlDate) >= 75;
    }

    @Override
    public void setDateControl(LocalDate dateControl) {
        this.controlDate = dateControl;
    }
}
