package ru.job4j.assertj;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String result = box.whatsThis();
        assertThat(result).isNotNull()
                .isNotEmpty()
                .isEqualTo("Sphere");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 10);
        String result = box.whatsThis();
        assertThat(result).isNotNull()
                .isNotEmpty()
                .isEqualTo("Tetrahedron");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 10);
        String result = box.whatsThis();
        assertThat(result).isNotNull()
                .isNotEmpty()
                .startsWith("Cu")
                .isEqualTo("Cube");
    }

    @Test
    void isThisUnknown() {
        Box box = new Box(-1, 0);
        String result = box.whatsThis();
        assertThat(result).isNotNull()
                .isNotEmpty()
                .isEqualTo("Unknown object");
    }

    @Test
    void checkSphereVertices() {
        Box box = new Box(0, 10);
        int result = box.getNumberOfVertices();
        assertThat(result).isLessThan(1)
                .isGreaterThan(-1)
                .isEqualTo(0);
    }

    @Test
    void checkTetrahedronVertices() {
        Box box = new Box(4, 10);
        int result = box.getNumberOfVertices();
        assertThat(result).isGreaterThan(3)
                .isLessThan(5)
                .isEqualTo(4);
    }

    @Test
    void checkWhenMinus1() {
        Box box = new Box(9, 7);
        int result = box.getNumberOfVertices();
        assertThat(result).isLessThan(0)
                .isEqualTo(-1);
    }

    @Test
    void whenExist() {
        Box box = new Box(8, 10);
        boolean result = box.isExist();
        assertThat(result).isTrue();
    }

    @Test
    void whenNotExist() {
        Box box = new Box(7, 11);
        boolean result = box.isExist();
        assertThat(result).isFalse();
    }

    @Test
    void checkSphereArea() {
        Box box = new Box(0, 10);
        double result = box.getArea();
        assertThat(result).isEqualTo(1256.64D, withPrecision(0.006D));
    }

    @Test
    void checkTetrahedronArea() {
        Box box = new Box(4, 10);
        double result = box.getArea();
        assertThat(result).isEqualTo(173.21D, withPrecision(0.006D))
                .isCloseTo(173.2D, withPrecision(0.01D))
                .isCloseTo(173.21D, Percentage.withPercentage(1.0D));
    }

    @Test
    void checkCubeArea() {
        Box box = new Box(8, 10);
        double result = box.getArea();
        assertThat(result).isEqualTo(600.0D, withPrecision(0.006D))
                .isCloseTo(600.0D, withPrecision(0.01D));
    }
}