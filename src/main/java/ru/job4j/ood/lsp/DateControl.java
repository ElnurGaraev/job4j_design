package ru.job4j.ood.lsp;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class DateControl {
    public float spendDate(LocalDate created, LocalDate expired) {
        long remainDays = DAYS.between(LocalDate.now(), expired);
        long totalDays = DAYS.between(created, expired);
        float remainPercent = ((float) remainDays / (float) totalDays) * 100;
        return remainPercent;
    }


}
