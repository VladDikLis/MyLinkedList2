package ru.otus.java.basic.homework;

public class MyStack<T> {
    private MyLinkedList<T> stack;

    public MyStack() {
        stack = new MyLinkedList<>();
    }

    public void push(T data) {
        stack.addFirst(data);
    }

    public T pop() {
        return stack.remove(0);
    }
}
