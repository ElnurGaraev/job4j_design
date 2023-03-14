package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.*;

@Disabled
class GeneratorTest {
    @Test
    public void whenPatternIsNotCorrect() {
        GeneratorGreeting generator = new GeneratorGreeting();
        assertThatThrownBy(
                () -> generator.produce(new String(), new HashMap<>()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("The pattern is not correct.");
    }

    @Test
    public void whenKeyInThePatternIsAbsent() {
        GeneratorGreeting generator = new GeneratorGreeting();
        assertThatThrownBy(
                () -> generator.produce(new String(), new HashMap<>()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Ключ в шаблоне отсутствует.");
    }

    @Test
    public void whenValueInThePatternIsAbsent() {
        GeneratorGreeting generator = new GeneratorGreeting();
        assertThatThrownBy(
                () -> generator.produce(new String(), new HashMap<>()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Значение в шаблоне отсутствует.");
    }

    @Test
    public void whenKeyInTheMapIsAbsent() {
        GeneratorGreeting generator = new GeneratorGreeting();
        assertThatThrownBy(
                () -> generator.produce(new String(), new HashMap<>()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Ключ в карте отсутствует.");
    }

    @Test
    public void whenKeysInTheMapNotMatchedWithPatternKeys() {
        GeneratorGreeting generator = new GeneratorGreeting();
        assertThatThrownBy(
                () -> generator.produce(new String(), new HashMap<>()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Ключи в карте не совпадают с ключами в шаблоне.");
    }

    @Test
    public void whenGetPattern() {
        GeneratorGreeting generator = new GeneratorGreeting();
        String rsl = generator.produce(new String(), new HashMap<>());
        assertThat(rsl).isEqualTo(new String());
    }
}