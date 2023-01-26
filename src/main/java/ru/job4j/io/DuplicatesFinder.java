package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        DuplicatesVisitor dup = new DuplicatesVisitor();
        Files.walkFileTree(Path.of("./"), dup);
        dup.print(dup);
    }
}
