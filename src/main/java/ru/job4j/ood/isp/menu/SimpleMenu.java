package ru.job4j.ood.isp.menu;

import java.util.*;

public class SimpleMenu implements Menu {

    private final List<MenuItem> rootElements = new ArrayList<>();

    @Override
    public boolean add(String parentName, String childName, ActionDelegate actionDelegate) {
        boolean rsl = false;
        Optional<ItemInfo> infoParent = findItem(parentName);
        Optional<ItemInfo> infoChild = findItem(childName);
        if (parentName == ROOT) {
            rootElements.add(new SimpleMenuItem(childName, actionDelegate));
            rsl = true;
        } else if (infoParent.isPresent()) {
            infoParent.get().menuItem.getChildren().add(new SimpleMenuItem(childName, actionDelegate));
            rsl = true;
        } else if (infoParent.isEmpty() && infoChild.isPresent()) {
            rsl = false;
        }
        return rsl;
    }

    @Override
    public Optional<MenuItemInfo> select(String itemName) {
        Optional<MenuItemInfo> rsl = Optional.empty();
        Optional<ItemInfo> item = findItem(itemName);
        if (item.isPresent()) {
            rsl = Optional.of(new MenuItemInfo(item.get().menuItem, item.get().number));
        }
        return rsl;
    }

    @Override
    public Iterator<MenuItemInfo> iterator() {
        return new Iterator<>() {
            DFSIterator dfsIterator = new DFSIterator();
            @Override
            public boolean hasNext() {
                boolean rsl = false;
                if (dfsIterator.hasNext()) {
                    rsl = true;
                }
                return rsl;
            }

            @Override
            public MenuItemInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                ItemInfo info = dfsIterator.next();
                return new MenuItemInfo(info.menuItem, info.number);
            }
        };
    }

    private Optional<ItemInfo> findItem(String name) {
        Optional<ItemInfo> rsl = Optional.empty();
        DFSIterator dfsIterator = new DFSIterator();
        while (dfsIterator.hasNext()) {
            ItemInfo info = dfsIterator.next();
            if (info.menuItem.getName().equals(name)) {
                rsl = Optional.of(info);
                break;
            }
        }
        return rsl;
    }

    private static class SimpleMenuItem implements MenuItem {

        private String name;
        private List<MenuItem> children = new ArrayList<>();
        private ActionDelegate actionDelegate;

        public SimpleMenuItem(String name, ActionDelegate actionDelegate) {
            this.name = name;
            this.actionDelegate = actionDelegate;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public List<MenuItem> getChildren() {
            return children;
        }

        @Override
        public ActionDelegate getActionDelegate() {
            return actionDelegate;
        }
    }

    private class DFSIterator implements Iterator<ItemInfo> {

        Deque<MenuItem> stack = new LinkedList<>();

        Deque<String> numbers = new LinkedList<>();

        DFSIterator() {
            int number = 1;
            for (MenuItem item : rootElements) {
                stack.addLast(item);
                numbers.addLast(String.valueOf(number++).concat("."));
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public ItemInfo next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            MenuItem current = stack.removeFirst();
            String lastNumber = numbers.removeFirst();
            List<MenuItem> children = current.getChildren();
            int currentNumber = children.size();
            for (var i = children.listIterator(children.size()); i.hasPrevious();) {
                stack.addFirst(i.previous());
                numbers.addFirst(lastNumber.concat(String.valueOf(currentNumber--)).concat("."));
            }
            return new ItemInfo(current, lastNumber);
        }

    }

    private class ItemInfo {

        MenuItem menuItem;
        String number;

        public ItemInfo(MenuItem menuItem, String number) {
            this.menuItem = menuItem;
            this.number = number;
        }
    }
}
