package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class FirstParking implements Parking {
    private List<Car> carsList = new ArrayList<>();
    private int totalPlaces = 4;
    private int countFreePlaces = 0;


    @Override
    public boolean add(List<Car> cars) {
        boolean rsl = false;
        for (Car car : cars) {
            if (getStatusCar(car)) {
                rsl = true;
            } else if (!(getStatusCar(car)) && car.getSize(car) < 2
                    && countFreePlaces < totalPlaces) {
                carsList.add(car);
                countFreePlaces++;
                rsl = inform(car);
            } else if (!(getStatusCar(car)) && car.getSize(car) > 1
            && countFreePlaces < (totalPlaces - 1)) {
                carsList.add(car);
                countFreePlaces = countFreePlaces + 2;
                rsl = inform(car);
            } else {
                System.out.println("The parking has no free places");
            }
        }
        return rsl;
    }

    @Override
    public int getSizeCar(Car car) {
        return car.getSize(car);
    }

    @Override
    public boolean getStatusCar(Car car) {
        boolean rsl = false;
        if (car.getStatus(car)) {
            rsl = true;
        }
        return rsl;
    }

    @Override
    public boolean inform(Car car) {
        boolean rsl = false;
        if (!car.getStatus(car)) {
            rsl = car.changeStatus(car);
            System.out.println("Автомобиль на парковке" + " " + car.getName(car));
        } else {
            rsl = car.changeStatus(car);
            System.out.println("Автомобиль на снят с парковке" + " " + car.getName(car));
        }
        return rsl;
    }
}
