package ru.job4j.ood.srp;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SimpleSequenceGenerator implements SequenceGenerator<Integer> {
    private NumberGenerator<Integer> numberGenerator;

    public SimpleSequenceGenerator(NumberGenerator<Integer> numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public List<Integer> generate(int size) {
        return IntStream.range(0, size)
                .map(i -> numberGenerator.generate())
                .boxed()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        SimpleSequenceGenerator sequenceGenerator = new SimpleSequenceGenerator(new NumberGenerator<Integer>() {
            @Override
            public Integer generate() {
                return new Random().nextInt();
            }
        });

        Output output = new Output() {
            @Override
            public void print(String msg) {
                System.out.println(msg);
            }
        };
        output.print(sequenceGenerator.generate(5).toString());
    }
}
