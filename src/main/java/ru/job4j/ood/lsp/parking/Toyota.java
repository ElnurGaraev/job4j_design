package ru.job4j.ood.lsp.parking;

import java.util.List;

public class Toyota implements Car {
    private String name;
    private int size;
    private boolean status;

    public Toyota(String name, int size, boolean status) {
        this.name = name;
        this.size = size;
        this.status = status;
    }

    @Override
    public int getSize(Car car) {
        return size;
    }

    @Override
    public boolean getStatus(Car car) {
        return status;
    }

    @Override
    public boolean changeStatus(Car car) {
        boolean rsl = false;
        if (!status) {
            this.status = true;
            rsl = true;
        } else if (status) {
            this.status = false;
            rsl = false;
        }
        return rsl;
    }

    @Override
    public String getName(Car car) {
        return name;
    }
}




