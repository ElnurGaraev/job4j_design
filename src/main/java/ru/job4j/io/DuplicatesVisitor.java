package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Map<FileProperty, List<Path>> map = new HashMap<>();
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(file.toFile().length(), file.toFile().getName());
        map.putIfAbsent(fileProperty, new ArrayList<>());
        map.get(fileProperty).add(file);
        return super.visitFile(file, attrs);
    }

    public Map<FileProperty, List<Path>> getMap() {
        return map;
    }

    public void print(DuplicatesVisitor duplicate) {
        Map<FileProperty, List<Path>> mapDup = duplicate.getMap();
        Map<FileProperty, List<Path>> rsl = mapDup.entrySet().stream()
                .filter(e -> e.getValue().size() > 1)
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
        for (Map.Entry<FileProperty, List<Path>> result : rsl.entrySet()) {
            System.out.println(String.format("File name: %s, file size: %s",
                    result.getKey().getName(), result.getKey().getSize()));
            result.getValue().forEach(System.out::println);
        }
    }
}
