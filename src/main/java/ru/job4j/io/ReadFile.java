package ru.job4j.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InaccessibleObjectException;

public class ReadFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("data/input.txt");
             FileInputStream in = new FileInputStream("data/input.txt")) {
            out.write(("login=login").getBytes());
            out.write((System.lineSeparator()).getBytes());
            out.write(("password=password").getBytes());
            out.write((System.lineSeparator()).getBytes());
            out.write(("url=url").getBytes());
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            System.out.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
