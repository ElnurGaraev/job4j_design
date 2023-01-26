package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Map<FileProperty, Path> map = new HashMap<>();
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(file.toFile().length(), file.toFile().getName());
        if (!map.containsKey(fileProperty)) {
            map.put(fileProperty, file);
        } else {
            System.out.println(String.format("File name: %s, file size:  %s", file.toFile().getName(), file.toFile().length()));
            System.out.println(file.toAbsolutePath());
        }
        return super.visitFile(file, attrs);
    }
}
