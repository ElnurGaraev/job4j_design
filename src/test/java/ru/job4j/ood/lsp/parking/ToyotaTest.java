package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ToyotaTest {
    @Test
    public void whenGetCarSize() {
        Toyota toyota = new Toyota("Corolla", 1, false);
        int rsl = toyota.getSize(toyota);
        int exp = 1;
        assertThat(rsl).isEqualTo(exp);
    }

    @Test
    public void whenStatusParkingFalse() {
        Toyota toyota = new Toyota("Corolla", 1, false);
        boolean rsl = toyota.getStatus(toyota);
        assertThat(rsl).isFalse();
    }

    @Test
    public void whenChangeParkingStatus() {
        Toyota toyota = new Toyota("Corolla", 1, false);
        boolean rsl = toyota.changeStatus(toyota);
        assertThat(rsl).isTrue();
    }
}