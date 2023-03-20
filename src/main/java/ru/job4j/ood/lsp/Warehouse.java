package ru.job4j.ood.lsp;

public class Warehouse extends AbstractStore {
    @Override
    public boolean isFresh(Food food) {
        return spendDate(food) >= 75;
    }
}
