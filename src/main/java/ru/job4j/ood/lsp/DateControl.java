package ru.job4j.ood.lsp;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class DateControl {
    public float spendDate(LocalDate created, LocalDate expired, LocalDate controlDate) {
        float remainPercent;
        if (created.isAfter(expired)) {
            throw new IllegalArgumentException("Дата истечения срока должна быть раньше даты изготовления");
        } else {
            long remainDays = DAYS.between(expired, controlDate);
            long totalDays = DAYS.between(expired, created);
            remainPercent = ((float) remainDays / (float) totalDays) * 100;
        }
        return remainPercent;
    }
}
