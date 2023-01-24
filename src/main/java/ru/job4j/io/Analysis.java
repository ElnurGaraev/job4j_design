package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Analysis {
    public void unavailable(String source, String target) {
        String line;
        String time = null;
        try (BufferedReader in = new BufferedReader(
                new FileReader(source));
        FileWriter out = new FileWriter(target)) {
            while ((line = in.readLine()) != null) {
                String[] str = line.split(" ", 2);
                if (time == null && (line.contains("400") || line.contains("500"))) {
                    time = str[1];
                } else if (time != null && (line.contains("200") || line.contains("300"))) {
                    out.write(time + System.lineSeparator() + str[1]);
                    out.write(System.lineSeparator());
                    time = null;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}
