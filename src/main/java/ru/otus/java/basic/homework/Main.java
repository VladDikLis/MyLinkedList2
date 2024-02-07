package ru.otus.java.basic.homework;

public class Main {
    public static void main(String[] args) {

        MyLinkedList<Object> linkedList = new MyLinkedList<>();
        linkedList.addFirst(1);
        linkedList.addLast(2);
        System.out.println(linkedList.getSize());
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());

        MyQueue<Integer> queue = new MyQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.poll();

        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.pop();

        int[] arr = {3, 2, 1};

        arr = sort(arr);

    }
    public static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
