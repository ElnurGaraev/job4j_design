package ru.job4j.ood.lsp;

public class Shop extends AbstractStore {
    @Override
    public boolean isFresh(Food food) {
        boolean rsl = false;
        if (spendDate(food) >= 25 && spendDate(food) <= 75) {
            rsl = true;
        } else if (spendDate(food) < 25) {
            food.setDiscount(0.5F);
            rsl = true;
        }
        return rsl;
    }
}
