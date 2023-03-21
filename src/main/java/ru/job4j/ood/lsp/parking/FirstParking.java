package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class FirstParking implements Parking {
    private List<Car> cars = new ArrayList<>();
    private int totalPlaces = 10;
    private int countFreePlaces;

    public FirstParking() {
        this.cars = cars;
    }

    @Override
    public boolean add(Car car) {
        return false;
    }
}
