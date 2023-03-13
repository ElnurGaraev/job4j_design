package ru.job4j.kiss;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaxMin {

    public <T> T check(List<T> values, Comparator<T> comparator) {
        T rsl = values.get(0);
        for (T value : values) {
            if (comparator.compare(rsl, value) > 0) {
                rsl = value;
            }
        }
        return rsl;
    }

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return check(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return check(value, comparator.reversed());
    }
}
