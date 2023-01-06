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

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T rsl = head.item;
        if (head != null) {
            head = head.next;
        }
        return rsl;
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
