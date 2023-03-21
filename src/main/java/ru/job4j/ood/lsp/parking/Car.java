package ru.job4j.ood.lsp.parking;

import java.util.List;

public interface Car {
    int getSize(Car car);
    boolean getStatus(Car car);
    boolean changeStatus(boolean parkStatus);
}
