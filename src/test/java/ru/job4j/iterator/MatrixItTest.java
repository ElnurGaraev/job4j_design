package ru.job4j.iterator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MatrixItTest {
    @Test
    void when4El() {
        int[][] in = {
                {1}
        };
        MatrixIt it = new MatrixIt(in);
        assertThat(it.next()).isEqualTo(1);
    }

    @Test
    void whenFirstEmptyThenNext() {
        int[][] in = {
                {}, {1}
        };
        MatrixIt it = new MatrixIt(in);
        assertThat(it.next()).isEqualTo(1);
    }

    @Test
    void whenFirstEmptyThenHashNext() {
        int[][] in = {
                {}, {1}
        };
        MatrixIt it = new MatrixIt(in);
        assertThat(it.hasNext()).isTrue();
    }

    @Test
    void whenRowHasDiffSize() {
        int[][] in = {
                {1}, {2, 3}, {}, {}, {4}
        };
        MatrixIt it = new MatrixIt(in);
        assertThat(it.next()).isEqualTo(1);
        assertThat(it.next()).isEqualTo(2);
        assertThat(it.next()).isEqualTo(3);
        assertThat(it.next()).isEqualTo(4);
        assertThat(it.hasNext()).isFalse();
    }
}