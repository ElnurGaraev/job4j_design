package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Analize {
    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 1;
        int changed = 1;
        int deleted = 1;
        Info rsl = new Info(0, 0, 0);
        Map<Integer, String> prevMap = previous.stream()
                .collect(Collectors.toMap(User::getId, User::getName));
        Map<Integer, String> currentMap = current.stream()
                .collect(Collectors.toMap(User :: getId, User :: getName));
        for (Map.Entry<Integer, String> entry : prevMap.entrySet()) {
            if (currentMap.containsKey(entry.getKey()) && !entry.getValue().equals(currentMap.get(entry.getKey()))) {
                rsl.setChanged(changed++);
            } else if (!currentMap.containsKey(entry.getKey())) {
                rsl.setDeleted(deleted++);
            }
        }
        for (Map.Entry<Integer, String> entry : currentMap.entrySet()) {
            if (!prevMap.containsKey(entry.getKey())) {
                rsl.setAdded(added++);
            }
        }
        return rsl;
    }
}

