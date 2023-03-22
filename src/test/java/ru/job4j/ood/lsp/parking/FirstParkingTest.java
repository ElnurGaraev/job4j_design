package ru.job4j.ood.lsp.parking;

import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class FirstParkingTest {
    @Test
    public void whenAddCarToPark() {
        Toyota toyota = new Toyota("Corolla", 1, false);
        Ford ford = new Ford("F150", 2, false);
        List<Car> cars = List.of(toyota, ford);
        FirstParking firstParking = new FirstParking();
        boolean rsl = firstParking.add(cars);
        assertThat(rsl).isTrue();
    }
    @Test
    public void whenGetCarSize() {
        Toyota toyota = new Toyota("Corolla", 1, false);
        FirstParking firstParking = new FirstParking();
        int rsl = firstParking.getSizeCar(toyota);
        assertThat(rsl).isEqualTo(1);
    }

    @Test
    public void whenParkingStatusIsFalse() {
        Toyota toyota = new Toyota("Corolla", 1, false);
        FirstParking firstParking = new FirstParking();
        boolean rsl = firstParking.getStatusCar(toyota);
        assertThat(rsl).isFalse();
    }

    @Test
    public void whenParkingStatusIsTrue() {
        Toyota toyota = new Toyota("Corolla", 1, false);
        List<Car> cars = List.of(toyota);
        FirstParking firstParking = new FirstParking();
        boolean rsl = firstParking.add(cars);
        assertThat(rsl).isTrue();
    }

    @Test
    public  void whenParkingIsFull() {
        Ford ford = new Ford("F150", 2, false);
        Ford ford2 = new Ford("F150", 2, false);
        List<Car> cars = List.of(ford, ford2);
        FirstParking firstParking = new FirstParking();
        boolean rsl = firstParking.add(cars);
        assertThat(rsl).isTrue();
        Toyota toyota = new Toyota("Corolla", 1, false);
        List<Car> car = List.of(toyota);
        rsl = firstParking.add(car);
        assertThat(rsl).isFalse();
    }
}