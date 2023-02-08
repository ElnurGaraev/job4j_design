package ru.job4j.test;

import ru.job4j.io.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SearchFile {

    public void searchFile(ArgsName argsName) throws IOException {
        List<Path> paths = new ArrayList<>();
        if (argsName.get("t").equals("name")) {
            paths = Search.search(Paths.get(argsName.get("d")), p -> p.toFile().getName().contains(argsName.get("n")));
        }
        if (argsName.get("t").equals("mask")) {
            String pattern = argsName.get("n").replace("*", "\\w+").replace("?", "\\w{1}");
            paths = Search.search(Paths.get(argsName.get("d")), p -> p.toFile().getName().matches(pattern));
        }
        write(paths, argsName);
    }

    public void write(List<Path> paths, ArgsName argsName) {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(argsName.get("o")))) {
            for (Path path : paths) {
                writer.write(path.toFile().getAbsolutePath());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void validate(ArgsName argsName) {
        if (!new File(argsName.get("d")).isDirectory()) {
            throw new IllegalArgumentException("Directory in the parameter is not found");
        }
        if (!argsName.get("n").startsWith(".") && !argsName.get("n").startsWith("*")) {
            throw new IllegalArgumentException("Source file in the parameter is not found");
        }
        if (!argsName.get("t").contains("mask") && !argsName.get("t").contains("name")
        && !argsName.get("t").contains("regex")) {
            throw new IllegalArgumentException("Search type in the argument is not correct");
        }
        if (!argsName.get("o").endsWith(".txt")) {
            throw new IllegalArgumentException("Target file in the parameter is not found");
        }
    }

    public static void main(String[] args) throws IOException {
        SearchFile searchFile = new SearchFile();
        ArgsName argsName = ArgsName.of(args);
        searchFile.validate(argsName);
        searchFile.searchFile(argsName);
    }
}
