package ru.job4j.ood.lsp;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WarehouseTest {
    @Test
    public void whenFoodPutToWarehouse() {
        Store warehouse = new Warehouse(LocalDate.of(2023, 03, 21));
        Food food = new Food("Apple", LocalDate.of(2023, 04, 20),
                LocalDate.of(2023, 03, 18), 15, 0);
        warehouse.put(food);
        List<Food> exp = List.of(food);
        assertThat(warehouse.get()).isEqualTo(exp);
    }
}