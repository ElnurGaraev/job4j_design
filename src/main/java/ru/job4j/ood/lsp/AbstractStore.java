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
