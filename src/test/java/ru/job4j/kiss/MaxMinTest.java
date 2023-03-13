package ru.job4j.kiss;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MaxMinTest {
    @Test
    void whenMax() {
        List<Integer> list = List.of(1, 4, 5, 6);
        MaxMin maxMin = new MaxMin();
        int rsl = maxMin.min(list, (x, y) -> x.compareTo(y));
        int exp = 6;
        assertThat(rsl).isEqualTo(exp);
    }

    @Test
    void whenMin() {
        List<Integer> list = List.of(5, 3, -5, 8);
        MaxMin maxMin = new MaxMin();
        int rsl = maxMin.min(list, (x, y) -> y.compareTo(x));
        int exp = -5;
        assertThat(rsl).isEqualTo(exp);
    }
}