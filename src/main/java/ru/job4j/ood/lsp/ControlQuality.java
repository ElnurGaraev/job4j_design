package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControlQuality {
    List<Store> stores = new ArrayList<>();

    public ControlQuality() {
        this.stores = stores;
    }

    public void setStore(Store store) {
        stores.add(store);
    }

    public boolean checkProduct(Food food) {
        boolean rsl = true;
        for (Store store : stores) {
            if (store.put(food)) {
                break;
            } else {
                rsl = false;
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        Food food = new Food("Apple", LocalDate.of(2023, 03, 22),
                LocalDate.of(2023, 03, 03), 15, 0);
        ControlQuality controlQuality = new ControlQuality();
        Store shop = new Shop();
        controlQuality.setStore(shop);
        controlQuality.checkProduct(food);
        System.out.println(shop.get().get(0).getPrice() + shop.get().get(0).getName());

    }
}
