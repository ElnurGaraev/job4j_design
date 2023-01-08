package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ForwardLinked<T> implements LinkedList<T> {
    private int size = 0;
    private int modCount = 0;
    private Node<T> head;

    public void add(T value) {
        Node<T> newNode = new Node(value, null);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }
        size++;
        modCount++;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        Node<T> target = head;
        for (int i = 0; i < index; i++) {
            target = target.next;
        }
        return target.item;
    }

    public boolean revert() {
        boolean rsl = size != 0 && size != 1;
        if (rsl) {
            Node<T> current = head;
            Node<T> prev = null;
            while (current != null) {
                Node<T> next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            head = prev;
        }
        return rsl;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> del = head;
        T result = head.item;
        head = del.next;
        del.next = null;
        del.item = null;
        size--;
        modCount++;
        return result;
    }

    public void addFirst(T value) {
        head = new Node<>(value, head);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> target = head;
            final int oldModCount = modCount;
            @Override
            public boolean hasNext() {
                if (oldModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return target != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<T> rsl = target;
                target = target.next;
                return rsl.item;
            }
        };
    }

    private static class Node<T> {
        private T item;
        private Node<T> next;

        public Node(T element, Node next) {
            this.item = element;
            this.next = next;
        }
    }
}
