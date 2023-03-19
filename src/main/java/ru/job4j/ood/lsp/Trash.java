package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Trash extends AbstractStore {
    List<Food> trashList = new ArrayList<>();

    public Trash() {
        this.trashList = trashList;
    }

    @Override
    public void put(Food food) {
        if (spendDate(food) <= 0) {
            trashList.add(food);
        }
    }

    public List<Food> getTrashList() {
        return trashList;
    }
}
