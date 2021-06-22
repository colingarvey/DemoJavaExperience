package net.colingarvey;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Implementation of a LIFO data structure, otherwise known as a Stack. Uses linked-list logic to store a sequence
 * of generic T type.
 * @param <T>
 */
public class Stack <T> implements Iterable<T>{
    private Node top; // top of the stack
    private int size; // size (length) of stack

    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node active = top;

        public boolean hasNext() {
            return active !=null;
        }

        public T next() {
            T item = active.item;
            active = active.next;
            return item;
        }

        public void remove() {

        }
    }


    private class Node{
        /**
         * Nested class to store attributes related to items within the linked list.
         *
         */
        T item;
        Node next;
    }

    /**
     * Pops the top-most item on the stack.
     *
     * @return item Returns item of type T.
     */
    public T pop(){
        T item = top.item;
        top = top.next;
        size--;
        return item;
    }

    /**
     * Pushes a new item onto the stack.
     *
     * @param item item of type T to push onto the stack.
     */
    public void push(T item) {
        Node oldTop = top;
        top = new Node();
        top.item = item;
        top.next = oldTop;
        size++;
    }

    public boolean isEmpty(){ return top == null; }
    // returns whether the stack is empty or not

    public int size() { return size; }
    // returns the size of stack

    public static void main(String[] args) {
        // Instantiate a stack, push and pop strings from stdin.
        Stack<String> stack = new Stack<String>();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                String line = stdIn.readLine();
                if (line == null) {break;}
                stack.push(line);

            }
        } catch (IOException e) {
                e.printStackTrace();
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
            System.out.printf("Stack has %d items remaining.\n", stack.size());
        }
    }

}
