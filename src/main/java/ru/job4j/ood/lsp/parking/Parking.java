package ru.job4j.ood.lsp.parking;

import java.util.List;

public interface Parking {
    boolean add(List<Car> cars);
    int getSizeCar(Car car);
    boolean getStatusCar(Car car);
    boolean inform(Car car);

}
