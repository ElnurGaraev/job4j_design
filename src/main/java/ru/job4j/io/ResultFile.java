package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("data/result.txt")) {
            int size = 9;
            for (int row = 0; row < size; row++) {
                for (int cell = 0; cell < size; cell++) {
                    out.write(((row + 1) + " * " + (cell + 1) + " = " + (row + 1) * (cell + 1)).getBytes());
                    out.write(System.lineSeparator().getBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}