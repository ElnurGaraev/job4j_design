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

    public static void validate(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Argument is absent");
        }
        if (!(args[0].contains("=") && args[0].contains("-"))) {
            throw new IllegalArgumentException(("Symbol in the first argument is not correct"));
        }
        if (!(args[1].contains("=") && args[1].contains("-"))) {
            throw new IllegalArgumentException(("Symbol in the second argument is not correct"));
        }
        if (!(args[2].contains("=") && args[2].contains("-"))) {
            throw new IllegalArgumentException(("Symbol in the third argument is not correct"));
        }
    }

    public static void main(String[] args) throws IOException {
        Zip zip = new Zip();
        validate(args);
        ArgsName arg = ArgsName.of(args);
        Path source = Paths.get(arg.get("d"));
        List<Path> list = Search.search(source, p -> !p.toFile().getName().endsWith(arg.get("e")));
        zip.packSingleFile(
                new File("./pom.xml"),
                new File("./pom.zip")
        );
        zip.packFiles(list, new File(arg.get("o")));
    }
}
