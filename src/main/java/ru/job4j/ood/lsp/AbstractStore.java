package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public abstract class AbstractStore {

    public float spendDate(Food food) {
        long remainDays = DAYS.between(LocalDate.now(), food.getExpiryDate());
        long totalDays = DAYS.between(food.getCreateDate(), food.getExpiryDate());
        float remainPercent = ((float) remainDays / (float) totalDays) * 100;
        return remainPercent;
    }

    public abstract void put(Food food);
}
