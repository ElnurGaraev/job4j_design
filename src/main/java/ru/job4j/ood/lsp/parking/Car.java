package ru.job4j.ood.lsp.parking;



public interface Car {
    int getSize(Car car);
    boolean getStatus(Car car);
    boolean changeStatus(boolean parkStatus);
}
