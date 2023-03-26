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
        Store shop = new Shop(LocalDate.of(2023, 03, 21));
        Store warehouse = new Warehouse(LocalDate.of(2023, 03, 21));
        Store trash = new Trash(LocalDate.of(2023, 03, 21));
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
        Store shop = new Shop(LocalDate.of(2023, 03, 21));
        Store warehouse = new Warehouse(LocalDate.of(2023, 03, 21));
        Store trash = new Trash(LocalDate.of(2023, 03, 21));
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
        Store shop = new Shop(LocalDate.of(2023, 03, 21));
        Store warehouse = new Warehouse(LocalDate.of(2023, 03, 21));
        Store trash = new Trash(LocalDate.of(2023, 03, 21));
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
        Store shop = new Shop(LocalDate.of(2023, 03, 21));
        Store warehouse = new Warehouse(LocalDate.of(2023, 03, 21));
        Store trash = new Trash(LocalDate.of(2023, 03, 21));
        controlQuality.setStore(shop);
        controlQuality.setStore(trash);
        controlQuality.setStore(warehouse);
        controlQuality.checkProduct(food);
        List<Food> exp = List.of(food);
        assertThat(trash.get()).isEqualTo(exp);
    }

    @Test
    public void whenAddToStoreAndThenRestore() {
        Food apple = new Food("Apple", LocalDate.of(2023, 03, 30),
                LocalDate.of(2023, 03, 03), 15, 0);
        Food milk = new Food("Milk", LocalDate.of(2023, 03, 25),
                LocalDate.of(2023, 03, 10), 15, 0);
        Food orange = new Food("Orange", LocalDate.of(2023, 03, 27),
                LocalDate.of(2023, 03, 01), 15, 0);
        Store shop = new Shop(LocalDate.of(2023, 03, 26));
        Store warehouse = new Warehouse(LocalDate.of(2023, 03, 26));
        Store trash = new Trash(LocalDate.of(2023, 03, 26));
        ControlQuality controlQuality = new ControlQuality();
        controlQuality.setStore(shop);
        controlQuality.setStore(warehouse);
        controlQuality.setStore(trash);
        controlQuality.checkProduct(apple);
        controlQuality.checkProduct(milk);
        controlQuality.checkProduct(orange);
        assertThat(trash.get()).isEqualTo(List.of(milk));
        assertThat(shop.get()).isEqualTo(List.of(apple, orange));
        controlQuality.resort(LocalDate.of(2023, 03, 28));
        assertThat(trash.get()).isEqualTo(List.of(orange, milk));
        assertThat(shop.get()).isEqualTo(List.of(apple));
    }
}