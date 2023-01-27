package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (values.get(key) == null) {
            throw new IllegalArgumentException();
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        validate(args);
        for (String arg : args) {
            String[] value = arg.split("=", 2);
            String[] key = value[0].split("-", 2);
            values.put(key[1], value[1]);
        }
    }

    public void validate(String[] args) {
        ArgsName jvm = new ArgsName();
        if (args.length == 0) {
            throw new IllegalArgumentException();
        }
        for (String arg : args) {
            if (!arg.contains("-") && !arg.contains("=")) {
                throw new IllegalArgumentException();
            }
        }

        for (String arg : args) {
            String[] array = arg.split("=", 2);
            if (!array[0].startsWith("-") || array[0].isEmpty() || array[1].isEmpty()) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[]{"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}

