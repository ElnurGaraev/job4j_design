package ru.job4j.assertj;

import java.util.*;
import java.util.stream.Collectors;

public class NameLoad {
    private final Map<String, String> values = new HashMap<>();

    public void parse(String... names) {
        if (names.length == 0) {
            throw new IllegalArgumentException("Names array is empty");
        }
        values.putAll(Arrays.stream(names)
                .map(String::trim)
                .filter(this::validate)
                .map(s -> s.split("=", 2))
                .collect(Collectors.toMap(
                        e -> e[0],
                        e -> e[1],
                        (first, second) -> String.format("%s+%s", first, second)
                )));
    }

    private boolean validate(String name) {
        if (!name.contains("=")) {
            throw new IllegalArgumentException(
                    String.format("this name: %s does not contain the symbol \"=\"", name));
        }
        if (name.startsWith("=")) {
            throw new IllegalArgumentException(
                    String.format("this name: %s does not contain a key", name));
        }
        if (name.indexOf("=") == name.length() - 1) {
            throw new IllegalArgumentException(
                    String.format("this name: %s does not contain a value", name));
        }
        return true;
    }

    public Map<String, String> getMap() {
        if (values.isEmpty()) {
            throw new IllegalArgumentException("collection contains no data");
        }
        return values;
    }
}
