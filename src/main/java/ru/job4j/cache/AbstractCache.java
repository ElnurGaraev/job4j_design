package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {
    private final Map<K, SoftReference<V>> cache = new HashMap<>();

    public final void put(K key, V value) {
        cache.put(key, new SoftReference<>(value));
    }

    public final V get(K key) throws Exception {
        return cache.getOrDefault(key, new SoftReference<>(load(key))).get();
    }

    protected abstract V load(K key) throws Exception;
}
