package ru.job4j.ood.lsp;

public class Trash extends AbstractStore {
    @Override
    public boolean isFresh(Food food) {
        return spendDate(food) <= 0;
    }
}