package ru.job4j.ood.lsp;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class TrashTest {
    @Test
    public void whenPutFoodToTrash() {
        Store trash = new Trash(LocalDate.of(2023, 03, 21));
        Food food = new Food("Apple", LocalDate.of(2023, 03, 19),
                LocalDate.of(2023, 03, 03), 15, 0);
        trash.put(food);
        List<Food> exp = List.of(food);
        assertThat(trash.get()).isEqualTo(exp);
    }
}