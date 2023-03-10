package ru.job4j.cache.menu;

import ru.job4j.cache.DirFileCache;

import java.util.Scanner;

public class Emulator {
    public static final int LOAD = 1;
    public static final int SHOW_CASH = 2;
    public static final String SELECT = "Выберите меню";
    public static final String DIR = "Введите кэшируемую директорию";
    public static final String EXIT = "Конец работы";
    public static final String MENU = """
            Введите 1, чтобы загрузить содержимое файла в кэш.
            Введите 2, чтобы получить содержимое файла из кэша.
            """;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        new Emulator().start(scanner);
    }

    private void start(Scanner scanner) throws Exception {
        boolean run = true;
        while (run) {
            System.out.println(MENU);
            System.out.println(SELECT);
            int userChoice = Integer.valueOf(scanner.nextLine());
            System.out.println(userChoice);
            if (LOAD == userChoice) {
                System.out.println(DIR);
                new DirFileCache(scanner.nextLine()).get(scanner.nextLine());
            } else if (SHOW_CASH == userChoice) {
                System.out.println(DIR);
                System.out.println(new DirFileCache(scanner.nextLine()).get(scanner.nextLine()));
            } else {
                run = false;
                System.out.println(EXIT);
            }
        }
    }
}
