package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.util.List;

public interface Store {
    boolean put(Food food);
    List<Food> get();
   void setDateControl(LocalDate dateControl);
}
