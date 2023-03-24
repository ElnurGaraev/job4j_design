package ru.job4j.ood.isp.menu;

import java.util.Scanner;

public class TodoApp {

    private Menu menu;
    private Scanner scanner;

    public TodoApp(Menu menu, Scanner scanner) {
        this.menu = menu;
        this.scanner = scanner;
    }

    public static final ActionDelegate ACTION = System.out::println;
    public static final int CREATE_MENU_ITEM = 1;
    public static final int CREATE_MENU_SUB_ITEM = 2;
    public static final int SHOW_MENU = 3;
    public static final String INPUT_ITEM = "Введите название пункта";
    public static final String INPUT_SUB_ITEM = "Введите название подпункта";
    public static final String MENU = """
                Выберите пункт:
                Введите 1 для добавления пункта меню.
                Введите 2 для добавления подпункта меню.
                Введите 3, чтобы показать меню.
                Введите любое другое число для выхода.
            """;
    public static void main(String[] args) {
        TodoApp todoApp = new TodoApp(new SimpleMenu(), new Scanner(System.in));
        MenuPrinter print = new PrintConsoleMenu();
        boolean run = true;
        while (run) {
            System.out.println(MENU);
            int point = Integer.parseInt(todoApp.scanner.nextLine());
            System.out.println(point);
            if (point == CREATE_MENU_ITEM) {
                System.out.println(INPUT_ITEM);
                String parent = todoApp.scanner.nextLine();
                System.out.println(parent);
                todoApp.menu.add(Menu.ROOT, parent, ACTION);
            } else if (point == CREATE_MENU_SUB_ITEM) {
                System.out.println(INPUT_ITEM);
                String parent = todoApp.scanner.nextLine();
                System.out.println(INPUT_SUB_ITEM);
                String children = todoApp.scanner.nextLine();
                todoApp.menu.add(parent, children, ACTION);
            } else if (point == SHOW_MENU) {
                print.print(todoApp.menu);
            } else {
                run = false;
                System.out.println("Выход из приложения.");
            }
        }
    }
}
