package ru.job4j.assertj;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ModelTest {

    @Test
    void checkBoolean() {
        Model model = new Model(1, 5.255D, "name", true);
        boolean rsl = model.isCondition();
        assertThat(rsl).isTrue();
    }

    @Test
    void checkStringChain() {
        Model model = new Model(5, 5.255D, "I am learning Java", true);
        String rsl = model.getLine();
        assertThat(rsl).isNotNull()
                .isNotEmpty()
                .isNotBlank()
                .containsIgnoringCase("java")
                .contains("am", "Java")
                .doesNotContain("javascript")
                .startsWith("I am")
                .startsWithIgnoringCase("i")
                .endsWith("Java")
                .isEqualTo("I am learning Java");
    }

    @Test
    void checkInt() {
        Model model = new Model(2, 5.2d, "name", true);
        int result = model.getTop();
        assertThat(result).isNotZero()
                .isPositive()
                .isEven()
                .isGreaterThan(1)
                .isLessThan(3)
                .isEqualTo(2);
    }

    @Test
    void checkDoubleChain() {
        Model model = new Model(1, 5.255D, "name", true);
        double result = model.getNum();
        assertThat(result).isEqualTo(5.26D, withPrecision(0.006D))
                .isCloseTo(5.25D, withPrecision(0.01D))
                .isCloseTo(5.25D, Percentage.withPercentage(1.0D))
                .isGreaterThan(5.25D)
                .isLessThan(5.26D);
    }
}