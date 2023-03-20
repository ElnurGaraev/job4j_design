package ru.job4j.ood.lsp;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ControlQualityTest {
    @Test
    public void whenPutFoodToShop() {
        Food food = new Food("Apple", LocalDate.of(2023, 04, 19),
                LocalDate.of(2023, 03, 03), 15, 0);
        ControlQuality controlQuality = new ControlQuality();
        Store shop = new Shop();
        Store warehouse = new Warehouse();
        Store trash = new Trash();
        controlQuality.setStore(shop);
        controlQuality.setStore(trash);
        controlQuality.setStore(warehouse);
        controlQuality.checkProduct(food);
        List<Food> exp = List.of(food);
        assertThat(shop.get()).isEqualTo(exp);
    }

    @Test
    public void whenPutFoodToShopWithDiscount() {
        Food food = new Food("Apple", LocalDate.of(2023, 03, 22),
                LocalDate.of(2023, 03, 03), 15, 0);
        ControlQuality controlQuality = new ControlQuality();
        Store shop = new Shop();
        Store warehouse = new Warehouse();
        Store trash = new Trash();
        controlQuality.setStore(shop);
        controlQuality.setStore(trash);
        controlQuality.setStore(warehouse);
        controlQuality.checkProduct(food);
        List<Food> list = shop.get();
        assertThat(list.get(0).getPrice()).isEqualTo(7.5F);
    }

    @Test
    public void whenPutFoodToWarehouse() {
        Food food = new Food("Apple", LocalDate.of(2023, 04, 10),
                LocalDate.of(2023, 03, 18), 15, 0);
        ControlQuality controlQuality = new ControlQuality();
        Store shop = new Shop();
        Store warehouse = new Warehouse();
        Store trash = new Trash();
        controlQuality.setStore(shop);
        controlQuality.setStore(trash);
        controlQuality.setStore(warehouse);
        controlQuality.checkProduct(food);
        List<Food> exp = List.of(food);
        assertThat(warehouse.get()).isEqualTo(exp);
    }

    @Test
    public void whenPutToTrash() {
        Food food = new Food("Apple", LocalDate.of(2023, 03, 20),
                LocalDate.of(2023, 03, 03), 15, 0);
        ControlQuality controlQuality = new ControlQuality();
        Store shop = new Shop();
        Store warehouse = new Warehouse();
        Store trash = new Trash();
        controlQuality.setStore(shop);
        controlQuality.setStore(trash);
        controlQuality.setStore(warehouse);
        controlQuality.checkProduct(food);
        List<Food> exp = List.of(food);
        assertThat(trash.get()).isEqualTo(exp);
    }
}