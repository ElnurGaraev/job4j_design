package ru.job4j.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class CSVReader {
    public static void handle(ArgsName argsName) throws IOException {
        List<String> lines = new ArrayList<>();
        List<String> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(argsName.get("path")))) {
            while (scanner.hasNext()) {
                lines.add(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filter = argsName.get("filter");
        String[] filters = filter.split(",");
        String[] headLine = lines.get(0).split(argsName.get("delimiter"));
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < filters.length; i++) {
            for (int j = 0; j < headLine.length; j++) {
                if (filters[i].equals(headLine[j])) {
                    index.add(j);
                }
            }
        }
        for (String line : lines) {
            StringJoiner join = new StringJoiner(argsName.get("delimiter"));
            String[] array = line.split(argsName.get("delimiter"));
            for (Integer ind : index) {
                join.add(array[ind]);
            }
            result.add(String.valueOf(join));
        }
        if (!"stdout".equals(argsName.get("out"))) {
            try (FileWriter fileWriter = new FileWriter(argsName.get("out"))) {
                for (String s : result) {
                    fileWriter.write(s + System.lineSeparator());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if ("stdout".equals(argsName.get("out"))) {
            for (String s : result) {
                System.out.println(s);
            }
        }
    }

    public static void validate(ArgsName argsName) {
        if (!argsName.get("path").endsWith(".csv")) {
            throw new IllegalArgumentException("File file is not correct");
        }
        if (!"stdout".equals(argsName.get("out")) && !argsName.get("out").endsWith(".csv")) {
            throw new IllegalArgumentException("Out argument is not correct");
        }
        if (!";".equals(argsName.get("delimiter")) && !",".equals(argsName.get("delimiter"))) {
            throw new IllegalArgumentException("Delimiter argument is not fined");
        }
        if (argsName.get("filter").length() == 0) {
            throw new IllegalArgumentException("Filter is not fined");
        }
    }

    public static void main(String[] args) throws IOException {
        ArgsName argsName = ArgsName.of(args);
        validate(argsName);
        handle(argsName);
    }
}
