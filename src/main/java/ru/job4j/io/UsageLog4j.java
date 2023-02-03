package ru.job4j.io;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String model = "Mercedes";
        byte month = 01;
        short owners = 2;
        int year = 2019;
        char carClass = 'E';
        long  kilometre = 200000L;
        boolean accident = false;
        float width = 1.86F;
        double length = 2.94;
        LOG.debug("Car info model : {}, month : {}, year : {}, carClass : {}, owners : {}",
                model, month, year, carClass, owners);
        LOG.error("Car characteristic width : {}, length : {}, kilometre : {}, accident : {}",
                width, length, kilometre, accident);
    }
}