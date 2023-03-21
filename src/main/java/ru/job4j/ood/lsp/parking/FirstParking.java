package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class FirstParking implements Parking {
    private List<Car> cars = new ArrayList<>();
    private int totalPlaces = 4;
    private int countFreePlaces;


    @Override
    public boolean add(List<Car> cars) {
        return false;
    }

    @Override
    public int getSizeCar(Car car) {
        return 0;
    }

    @Override
    public boolean getStatusCar(Car car) {
        return false;
    }

    @Override
    public boolean inform(Car car) {
        return false;
    }
}
