package ru.job4j.ood.lsp;

public class Shop extends AbstractStore {
    DateControl dateControl = new DateControl();

    public Shop() {
        this.dateControl = dateControl;
    }

    @Override
    public boolean isFresh(Food food) {
        boolean rsl = false;
        if (dateControl.spendDate(food.getCreateDate(), food.getExpiryDate()) >= 25
                && dateControl.spendDate(food.getCreateDate(), food.getExpiryDate()) <= 75) {
            rsl = true;
        } else if (dateControl.spendDate(food.getCreateDate(), food.getExpiryDate()) < 25
                && dateControl.spendDate(food.getCreateDate(), food.getExpiryDate()) > 0) {
            food.setDiscount(0.5F);
            rsl = true;
        }
        return rsl;
    }
}
