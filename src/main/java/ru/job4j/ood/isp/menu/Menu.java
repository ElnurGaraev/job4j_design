package ru.job4j.ood.isp.menu;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public interface Menu extends Iterable<Menu.MenuItemInfo> {
    String ROOT = null;
    boolean add(String parentName, String childName, ActionDelegate actionDelegate);
    Optional<MenuItemInfo> select(String itemName);

    class MenuItemInfo {
        private final String name;
        private final List<String> children;
        private final ActionDelegate actionDelegate;
        private final String number;

        public MenuItemInfo(MenuItem menuItem, String number) {
            this.name = menuItem.getName();
            this.children = menuItem.getChildren().stream().map(MenuItem::getName).collect(Collectors.toList());
            this.actionDelegate = menuItem.getActionDelegate();
            this.number = number;
        }

        public MenuItemInfo(String name, List<String> children,
                            ActionDelegate actionDelegate, String number) {
            this.name = name;
            this.children = children;
            this.actionDelegate = actionDelegate;
            this.number = number;
        }

        public String getName() {
            return name;
        }

        public List<String> getChildren() {
            return children;
        }

        public ActionDelegate getActionDelegate() {
            return actionDelegate;
        }

        public String getNumber() {
            return number;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            MenuItemInfo that = (MenuItemInfo) o;
            return Objects.equals(name, that.name)
                    && Objects.equals(children, that.children)
                    && Objects.equals(number, that.number);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, children, number);
        }
    }
}
