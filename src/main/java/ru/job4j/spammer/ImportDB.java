package ru.job4j.spammer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class ImportDB {
    private Properties cfg;
    private String dump;

    public ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    public List<User> load() throws IOException {
        String line;
        List<User> users = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(
                new FileReader(dump))) {
            while ((line = rd.readLine()) != null) {
                String[] rsl = line.split(";", 2);
                if (rsl[0] != null && rsl[1] != null) {
                    System.out.println(rsl[0]);
                    System.out.println(rsl[1]);
                    users.add(new User(rsl[0], rsl[1]
                    ));
                } else {
                    throw new IllegalArgumentException();
                }
            }
        }
        return users;
    }

    public void save(List<User> users) throws  Exception {
        Class.forName(cfg.getProperty("jdbc.driver"));
        try (Connection cnt = DriverManager.getConnection(
                cfg.getProperty("jdbc.url"),
                cfg.getProperty("jdbc.username"),
                cfg.getProperty("jdbc.password")
        )) {
            for (User user : users) {
                try (PreparedStatement ps = cnt.prepareStatement(
                        "INSERT INTO users(name, email) values(?, ?)"
                )) {
                    ps.setString(1, user.name);
                    ps.setString(2, user.email);
                    ps.execute();
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {
        Properties cfg = new Properties();
        try (InputStream in = ImportDB.class.getClassLoader().getResourceAsStream("appU.properties")) {
           cfg.load(in);
        }
        ImportDB db = new ImportDB(cfg, "./dump.txt");
    }
}
