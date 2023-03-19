package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControlQuality {
    List<AbstractStore> stores = new ArrayList<>();

    public ControlQuality() {
        this.stores = stores;
    }

    public void setStore(AbstractStore store) {
        stores.add(store);
    }

    public void checkProduct(Food food) {
        for (AbstractStore store : stores) {
            store.put(food);
        }
    }
}
