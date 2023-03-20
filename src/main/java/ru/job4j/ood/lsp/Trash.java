package ru.job4j.ood.lsp;

public class Trash extends AbstractStore {
    DateControl dateControl = new DateControl();

    public Trash() {
        this.dateControl = dateControl;
    }

    @Override
    public boolean isFresh(Food food) {
        return dateControl.spendDate(food.getCreateDate(), food.getExpiryDate()) <= 0;
    }
}