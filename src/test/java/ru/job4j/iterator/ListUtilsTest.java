package ru.job4j.iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.*;

class ListUtilsTest {
    private List<Integer> input;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>(Arrays.asList(1, 3));
    }

    @Test
    void whenAddBefore() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(3).contains(1, 2, 3);
    }

    @Test
    void whenAddBeforeWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfter() {
        ListUtils.addAfter(input, 0, 2);
        assertThat(input).hasSize(3).contains(1, 2, 3);
    }

    @Test
    void whenAddAfterWhitInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addAfter(input, 3, 5))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenRemoveElements() {
        Predicate<Integer> pred = f -> f.equals(1);
        ListUtils.removeIf(input, pred);
        assertThat(input).hasSize(1).contains(3);
    }

    @Test
    void whenAddBeforeThenRemoveElement() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(3).contains(1, 2, 3);
        ListUtils.removeIf(input,
                f -> f.equals(1));
        assertThat(input).hasSize(2).contains(2, 3);
    }

    @Test
    void whenReplaceIfTrue() {
        ListUtils.replaceIf(input,
                f -> f.equals(1), 2);
        assertThat(input).hasSize(2).contains(2, 3);
    }

    @Test
    void whenAddBeforeThenReplaceIfTrue() {
        ListUtils.addBefore(input, 1, 2);
        ListUtils.replaceIf(input,
                f -> f.equals(3), 2);
        assertThat(input).hasSize(3).contains(1, 2, 2);
    }

    @Test
    void whenRemoveAll() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1));
        ListUtils.removeAll(input, list);
        assertThat(input).hasSize(1).contains(3);
    }

    @Test
    void whenAddBeforeThenRemoveAll() {
        ListUtils.addBefore(input, 1, 2);
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2));
        ListUtils.removeAll(input, list);
        assertThat(input).hasSize(1).contains(3);
    }
}