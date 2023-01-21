package ru.job4j.io;

import java.io.FileOutputStream;
import java.util.Arrays;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("data/result.txt")) {
            int size = 9;
            for (int row = 0; row < size; row++) {
                for (int cell = 0; cell < size; cell++) {
                    out.write((row + " * " + cell + " = " + row * cell).getBytes());
                    out.write(System.lineSeparator().getBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}