package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

@Disabled
class GeneratorTest {
    @Test
    public void whenPatternIsNotCorrect() {
        GeneratorGreeting generator = new GeneratorGreeting();
        String pattern = "I am a, Who are?";
        Map<String, String> map = Map.of("name", "Petr", "subject", "you");
        assertThatThrownBy(
                () -> generator.produce(pattern, map))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("The pattern is not correct.");
    }

    @Test
    public void whenKeyInThePatternIsAbsent() {
        GeneratorGreeting generator = new GeneratorGreeting();
        String pattern = "Who are ${subject}?";
        Map<String, String> map = Map.of("name", "Petr", "subject", "you");
        assertThatThrownBy(
                () -> generator.produce(pattern, map))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Ключ в шаблоне отсутствует.");
    }

    @Test
    public void whenValueInThePatternIsAbsent() {
        GeneratorGreeting generator = new GeneratorGreeting();
        String pattern = "I am a ${name}";
        Map<String, String> map = Map.of("name", "Petr", "subject", "you");
        assertThatThrownBy(
                () -> generator.produce(pattern, map))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Значение в шаблоне отсутствует.");
    }

    @Test
    public void whenKeysInTheMapNotMatchedWithPatternKeys() {
        GeneratorGreeting generator = new GeneratorGreeting();
        String pattern = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = Map.of("subject", "you");
        assertThatThrownBy(
                () -> generator.produce(pattern, map))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Ключи в карте не совпадают с ключами в шаблоне.");
    }

    @Test
    public void whenGetPattern() {
        GeneratorGreeting generator = new GeneratorGreeting();
        String pattern = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = Map.of("name", "Petr", "subject", "you");
        String rsl = generator.produce(pattern, map);
        String exp = "I am a Petr, Who are you?";
        assertThat(rsl).isEqualTo(exp);
    }
}