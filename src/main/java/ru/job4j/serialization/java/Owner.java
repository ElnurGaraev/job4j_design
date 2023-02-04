package ru.job4j.serialization.java;

public class Owner {
    private final String name;

    public Owner(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Owner{"
                + "name='" + name + '\'' + '}';
    }
}
