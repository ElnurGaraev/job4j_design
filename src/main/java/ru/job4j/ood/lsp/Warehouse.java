package ru.job4j.ood.lsp;

public class Warehouse extends AbstractStore {
    DateControl dateControl = new DateControl();

    public Warehouse() {
        this.dateControl = dateControl;
    }

    @Override
    public boolean isFresh(Food food) {
        return dateControl.spendDate(food.getCreateDate(), food.getExpiryDate()) >= 75;
    }
}
