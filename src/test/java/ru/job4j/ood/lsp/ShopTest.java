package ru.job4j.ood.lsp;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ShopTest {
    @Test
    public void whenPutFoodToShop() {
        Food food = new Food("Apple", LocalDate.of(2023, 04, 19),
                LocalDate.of(2023, 03, 03), 15, 0);
        Store shop = new Shop();
        shop.put(food);
        List<Food> exp = List.of(food);
        assertThat(shop.get()).isEqualTo(exp);
    }

    @Test
    public void whenPutFoodWithDiscount() {
        Food food = new Food("Apple", LocalDate.of(2023, 03, 22),
                LocalDate.of(2023, 03, 03), 15, 0);
        Store shop = new Shop();
        shop.put(food);
        List<Food> foodList = shop.get();
        float price = foodList.get(0).getPrice();
        assertThat(price).isEqualTo(7.5F);
    }
}