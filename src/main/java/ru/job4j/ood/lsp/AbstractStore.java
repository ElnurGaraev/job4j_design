package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public abstract class AbstractStore implements Store {
    private List<Food> foodList = new ArrayList<>();

    public AbstractStore() {
        this.foodList = foodList;
    }

    public float spendDate(Food food) {
        long remainDays = DAYS.between(LocalDate.now(), food.getExpiryDate());
        long totalDays = DAYS.between(food.getCreateDate(), food.getExpiryDate());
        float remainPercent = ((float) remainDays / (float) totalDays) * 100;
        return remainPercent;
    }

    @Override
    public boolean put(Food food) {
        boolean rsl = true;
        if (isFresh(food)) {
            foodList.add(food);
        } else {
            rsl = false;
        }
        return rsl;
    }

    @Override
    public List<Food> get() {
        return foodList;
    }

    public abstract boolean isFresh(Food food);
}
