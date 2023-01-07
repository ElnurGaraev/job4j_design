package ru.job4j.collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

class SimpleQueueTest {
    private SimpleQueue<Integer> queue;

    @BeforeEach
    public void setUp() {
        queue = new SimpleQueue<>();
        queue.push(1);
    }

    @Test
    void whenPushPoll() {
        assertThat(queue.poll()).isEqualTo(1);
    }

    @Test
    void when2PushPoll() {
        queue.push(2);
        assertThat(queue.poll()).isEqualTo(1);
    }

    @Test
    void when2PushPollPushPoll() {
        queue.poll();
        queue.push(2);
        assertThat(queue.poll()).isEqualTo(2);
    }

    @Test
    void whenEmptyPoll() {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        assertThatThrownBy(() -> queue.poll())
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void when2PushPollPushPollEmpty() {
        queue.poll();
        queue.push(2);
        queue.poll();
        assertThatThrownBy(() -> queue.poll())
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void whenPushPushPollAndPush() {
        queue.push(2);
        queue.poll();
        queue.push(3);
        assertThat(queue.poll()).isEqualTo(2);
    }
}