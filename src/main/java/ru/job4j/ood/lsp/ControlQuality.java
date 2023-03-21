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
}
