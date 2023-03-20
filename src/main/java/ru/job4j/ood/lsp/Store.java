package ru.job4j.ood.lsp;

import java.util.List;

public interface Store {
    boolean put(Food food);
    List<Food> get();
}
