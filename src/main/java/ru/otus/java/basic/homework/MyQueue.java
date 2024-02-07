package ru.otus.java.basic.homework;

public class MyQueue<T> {
    private MyLinkedList<T> queue;

    public MyQueue() {
        queue = new MyLinkedList<>();
    }

    public void offer(T data) {
        queue.addLast(data);
    }

    public T poll() {
        return queue.remove(0);
    }
}
