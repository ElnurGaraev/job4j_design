package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(
                new FileOutputStream(target)))) {
            for (Path path : sources) {
                zip.putNextEntry(new ZipEntry(path.toFile().getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(path.toFile().getPath()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(
                new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void validate(ArgsName arg) {
        if (!new File(arg.get("d")).isDirectory()) {
            throw new IllegalArgumentException(("Directory is not correct."));
        }
        if (!(arg.get("e").length() > 1) || !arg.get("e").startsWith(".")) {
            throw new IllegalArgumentException(("Extension is not correct."));
        }
        if (!arg.get("o").endsWith("zip")) {
            throw new IllegalArgumentException(("This is not zip file."));
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length == 3) {
            throw new IllegalArgumentException("Argument is absent");
        }
        Zip zip = new Zip();
        ArgsName arg = ArgsName.of(args);
        validate(arg);
        Path source = Paths.get(arg.get("d"));
        List<Path> list = Search.search(source, p -> !p.toFile().getName().endsWith(arg.get("e")));
        zip.packSingleFile(
                new File("./pom.xml"),
                new File("./pom.zip")
        );
        zip.packFiles(list, new File(arg.get("o")));
    }
}
