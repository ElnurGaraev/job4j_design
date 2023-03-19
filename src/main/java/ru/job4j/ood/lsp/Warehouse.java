package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Warehouse extends AbstractStore {
    List<Food> warehouseFoods = new ArrayList<>();

    public Warehouse() {
        this.warehouseFoods = warehouseFoods;
    }

    @Override
    public void put(Food food) {
        if (spendDate(food) >= 75) {
            warehouseFoods.add(food);
        }
    }

    public List<Food> getWarehouseFoods() {
        return warehouseFoods;
    }
}
