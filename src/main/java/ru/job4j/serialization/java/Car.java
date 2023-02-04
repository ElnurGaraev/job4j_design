package ru.job4j.serialization.java;

import java.util.Arrays;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;

public class Car {
    private final boolean accident;
    private final int kilometres;
    private final String model;
    private final Owner owner;
    private final  String[] description;

    public Car(boolean accident, int kilometres, String model, Owner owner, String[] description) {
        this.accident = accident;
        this.kilometres = kilometres;
        this.model = model;
        this.owner = owner;
        this.description = description;
    }

    public boolean isAccident() {
        return accident;
    }

    public int getKilometres() {
        return kilometres;
    }

    public String getModel() {
        return model;
    }

    public Owner getOwner() {
        return owner;
    }

    public String[] getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Car{" + "accident=" + accident
                + ", kilometres=" + kilometres
                + ", model='" + model + '\''
                + ", owner=" + owner
                + ", description=" + Arrays.toString(description)
                + '}';
    }

    public static void main(String[] args) {
        final Car car = new Car(false, 15000, "Toyota",
                new Owner("Petrov"), new String[] {"white", "economy"});
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(car));
        final String carJson =
                "{"
                        + "\"accident\":false,"
                        + "\"kilometres\":25000,"
                        + "\"model\":Nissan,"
                        + "\"owner\":"
                        + "{"
                        + "\"name\":Petrov"
                        + "},"
                        + "\"description\":"
                        + "[\"black\",\"business\"]"
                        + "}";
        final Car carFromJ = gson.fromJson(carJson, Car.class);
        System.out.println(carFromJ);
        System.out.println();
        JSONObject jsonOwner = new JSONObject("{\"name\":\"Petrov\"}");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("accident", car.isAccident());
        jsonObject.put("kilometres", car.getKilometres());
        jsonObject.put("model", car.getModel());
        jsonObject.put("owner", jsonOwner);
        jsonObject.put("description", car.getDescription());
        System.out.println(jsonObject);
        System.out.println(new JSONObject(car));
    }
}