package ru.job4j.ood.lsp.parking;

import java.util.List;

public class Toyota implements Car {
    private String name;
    private int size;
    private boolean status;

    public Toyota(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public int getSize(Car car) {
        return 0;
    }

    @Override
    public boolean getStatus(Car car) {
        return false;
    }

    @Override
    public boolean changeStatus(boolean parkStatus) {
        return false;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }
}




