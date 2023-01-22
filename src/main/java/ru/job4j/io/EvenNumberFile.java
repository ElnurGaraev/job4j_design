package ru.job4j.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("data/even.txt");
        FileInputStream in = new FileInputStream("data/even.txt")) {
            out.write(("1").getBytes());
            out.write((System.lineSeparator()).getBytes());
            out.write(("6").getBytes());
            out.write((System.lineSeparator().getBytes()));
            out.write(("14").getBytes());
            out.write((System.lineSeparator().getBytes()));
            out.write(("17").getBytes());
            out.write((System.lineSeparator().getBytes()));
            StringBuilder str = new StringBuilder();
            int num;
            while ((num = in.read()) != -1) {
                str.append((char) num);
            }
            String[] numbers = str.toString().split(System.lineSeparator());
            for (String number : numbers) {
                int rsl = Integer.parseInt(number);
                if (rsl % 2 == 0) {
                    System.out.println(rsl);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
