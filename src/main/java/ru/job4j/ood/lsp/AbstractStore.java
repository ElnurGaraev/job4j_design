package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.time.temporal.ChronoUnit.DAYS;

public abstract class AbstractStore implements Store {
    private List<Food> foodList = new ArrayList<>();
    private LocalDate controlDate;

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
    public void clearList() {
        foodList.clear();
    }

    @Override
    public List<Food> get() {
        return foodList;
    }

    @Override
    public void setDateControl(LocalDate dateControl) {
        this.controlDate = dateControl;
    }

    public abstract boolean isFresh(Food food);
}
