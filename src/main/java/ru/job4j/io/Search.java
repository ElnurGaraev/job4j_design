package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        Search search = new Search();
        search.validate(args);
        Path start = Paths.get(args[0]);
        List<Path> list = search(start, p -> p.toFile().getName().endsWith(args[1]));
    }

    public  void validate(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null.Usage  ROOT_FOLDER.");
        }
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}
