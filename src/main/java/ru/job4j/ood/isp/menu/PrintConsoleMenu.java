package ru.job4j.ood.isp.menu;

import java.util.List;

public class PrintConsoleMenu implements MenuPrinter {

    @Override
    public void print(Menu menu) {
        String lines = "----";
        int number = 0;
        for (Menu.MenuItemInfo item : menu) {
            number = item.getNumber().split("\\.").length - 1;
            System.out.println(lines.repeat(number) + item.getNumber() + " " + item.getName());
        }
    }

    public static void main(String[] args) {
        final ActionDelegate STUB_ACTION = System.out::println;
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);
        new PrintConsoleMenu().print(menu);
    }
}
