package ru.job4j.gc.leak;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserGenerator implements Generate {
    public static final String PATH_NAMES = "src/main/java/ru/job4j/gc/leak/files/names.txt";
    public static final String PATH_SURNAMES = "src/main/java/ru/job4j/gc/leak/files/surnames.txt";
    public static final String PATH_PATRONS = "src/main/java/ru/job4j/gc/leak/files/patr.txt";

    public static final String SEPARATOR = " ";
    public static final int NEW_USERS = 1000;

    public List<String> names;
    public List<String> surnames;
    public List<String> patrons;
    private List<User> users = new ArrayList<>();
    private Random random;

    public UserGenerator(Random random) throws Exception {
        this.random = random;
        readAll();
    }

    @Override
    public void generate() {
        users.clear();
        for (int i = 0; i < NEW_USERS; i++) {
            String fullName = String.format("%s%s%s%s%s", surnames.get(random.nextInt(surnames.size())), SEPARATOR,
                    names.get(random.nextInt(names.size())), SEPARATOR, patrons.get(random.nextInt(patrons.size())));
            users.add(new User(fullName));
        }
    }

    private void readAll() throws Exception {
        names = read(PATH_NAMES);
        surnames = read(PATH_SURNAMES);
        patrons = read(PATH_PATRONS);

    }

    public User randomUser() {
        return users.get(random.nextInt(users.size()));
    }

    public List<User> getUsers() {
        return users;
    }
}
