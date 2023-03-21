package ru.job4j.ood.lsp.parking;

public class Ford implements Car {
    private String name;
    private int size;
    private boolean status;

    public Ford(String name, int size, boolean status) {
        this.name = name;
        this.size = size;
        this.status = status;
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
}
