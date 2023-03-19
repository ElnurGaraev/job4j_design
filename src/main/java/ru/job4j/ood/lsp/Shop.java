package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop extends AbstractStore {
    List<Food> shopFoods = new ArrayList<>();

    public Shop() {
        this.shopFoods = shopFoods;
    }

    @Override
    public void put(Food food) {
        if (spendDate(food) >= 25 && spendDate(food) <= 75) {
            shopFoods.add(food);
        } else if (spendDate(food) < 25) {
            food.setDiscount(0.5F);
            shopFoods.add(food);
        }
    }

    public List<Food> getShopFoods() {
        return shopFoods;
    }
}
