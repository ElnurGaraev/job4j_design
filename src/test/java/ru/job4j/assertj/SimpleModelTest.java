package ru.job4j.assertj;

import org.assertj.core.api.AbstractThrowableAssert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SimpleModelTest {
    @Test
    void checkGetName() {
        SimpleModel sm = new SimpleModel();
        assertThatThrownBy(sm::getName)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkSetName() {
        SimpleModel sm = new SimpleModel();
        assertThatThrownBy(() -> sm.setName("name", 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkMessage() {
        SimpleModel sm = new SimpleModel();
        String word = "name";
        int number = 5;
        assertThatThrownBy(() -> sm.setName(word, 5))
                .isInstanceOf(IllegalArgumentException.class)
                .message()
                .isNotEmpty();
    }

    @Test
    void checkWordMessage() {
        SimpleModel sm = new SimpleModel();
        String word = "name";
        int number = 5;
        assertThatThrownBy(() -> sm.setName(word, number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(word, number)
                .hasMessageContaining("name");
    }
}