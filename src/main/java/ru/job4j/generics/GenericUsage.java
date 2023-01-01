package ru.job4j.generics;

import java.util.*;

public class GenericUsage {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        new GenericUsage().printRsl(list);

        List<Person> persons = List.of(
                new Person("name", 21, new Date(9445413244L)));
        new GenericUsage().printInfo(persons);

        List<Programmer> programmers = List.of(
                new Programmer("Name", 35, new Date(594974646L)));
        new GenericUsage().printInfo(programmers);

        List<? super Integer> l = new ArrayList<>();
        new GenericUsage().addAll(l);
    }

    public void printRsl(Collection<?> col) {
        for (Iterator<?> it = col.iterator(); it.hasNext();) {
            Object next = it.next();
            System.out.println(next);
        }
    }

    public void printInfo(Collection<? extends Person> col) {
        for (Iterator<? extends Person> it = col.iterator(); it.hasNext(); ) {
            Person next = it.next();
            System.out.println(next);
        }
    }

    public void addAll(List<? super Integer> list) {
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
