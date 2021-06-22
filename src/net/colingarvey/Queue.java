package net.colingarvey;

import java.util.Iterator;

public class Queue <T> implements Iterable<T> {
    private Node first;
    private Node last;
    private int size;

    private class Node {
        T item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void enqueue(T item) {
        Node prev = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else prev.next = last;
        size++;
    }

    public T dequeue() {
        T item = first.item;
        first = first.next;
        size--;
        if (isEmpty()) last = null;
        return item;
    }

    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T>{
        private Node active = first;
        public boolean hasNext() {
            return active != null;
        }
        public void remove() {}
        public T next() {
            T item = active.item;
            active = active.next;
            return item;
        }
    }
}
