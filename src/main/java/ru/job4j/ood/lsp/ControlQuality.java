package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ControlQuality {
    private List<Store> stores = new ArrayList<>();

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

    public void resort(LocalDate dateControl) {
        List<Food> tempList = new ArrayList<>();
        for (Store store : stores) {
            tempList.addAll(store.get());
            store.clearList();
            store.setDateControl(dateControl);
        }
        tempList.stream().forEach(g -> checkProduct(g));
    }
}
