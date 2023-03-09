package ru.job4j.gc.leak;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CommentGenerator implements Generate {
    public static final String PATH_PHRASES = "src/main/java/ru/job4j/gc/leak/files/phrases.txt";

    public static final String SEPARATOR = System.lineSeparator();
    private List<Comment> comments = new ArrayList<>();
    public static final int COUNT = 50;
    private List<String> phrases;
    private UserGenerator userGenerator;
    private Random random;

    public CommentGenerator(Random random, UserGenerator userGenerator) throws Exception {
        this.userGenerator = userGenerator;
        this.random = random;
        read();
    }

    private void read() throws Exception {
        phrases = read(PATH_PHRASES);
    }

    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public void generate() {
        comments.clear();
        for (int i = 0; i < COUNT; i++) {
            String comment = String.format("%s%s%s%s%s",
                    phrases.get(random.nextInt(phrases.size())), SEPARATOR,
                    phrases.get(random.nextInt(phrases.size())), SEPARATOR,
                    phrases.get(random.nextInt(phrases.size())));
            comments.add(new Comment(comment,
                    userGenerator.randomUser()));
        }
    }
}
