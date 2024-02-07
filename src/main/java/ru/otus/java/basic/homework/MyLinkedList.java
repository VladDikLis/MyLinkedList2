package ru.otus.java.basic.homework;

public class MyLinkedList<T> {
        private Node<T> first;
        private Node<T> last;
        private int size;

        private static class Node<T> {
            private T data;
            private Node<T> next;
            private Node<T> prev;

            public Node(T data) {
                this.data = data;
            }
        }

        public void addFirst(T data) {
            Node<T> newNode = new Node<>(data);
            if (first == null) {
                first = newNode;
                last = newNode;
            } else {
                newNode.next = first;
                first.prev = newNode;
                first = newNode;
            }
            size++;
        }

        public void addLast(T data) {

            Node<T> newNode = new Node<>(data);
            if (last == null) {
                first = newNode;
                last = newNode;
            } else {
                newNode.prev = last;
                last.next = newNode;
                last = newNode;
            }
            size++;
        }

        public T getFirst() {
            if (first == null) {
                throw new IndexOutOfBoundsException("Отсутствуют элементы");
            }
            return first.data;
        }

        public T getLast() {
            if (last == null) {
                throw new IndexOutOfBoundsException("Отсутствуют элементы");
            }
            return last.data;
        }

        public void add(int position, T data) {
            if (position < 0 || position > size) {
                throw new IndexOutOfBoundsException("Нет элемента с такой позицией");
            }
            if (position == 0) {
                addFirst(data);
            } else if (position == size) {
                addLast(data);
            } else {
                Node<T> temp = getNode(position);
                Node<T> newNode = new Node<>(data);
                newNode.prev = temp.prev;
                newNode.next = temp;
                temp.prev.next = newNode;
                temp.prev = newNode;
                size++;
            }
        }

        public T remove(int position) {
            if (position < 0 || position >= size) {
                throw new IndexOutOfBoundsException("Нет элемента с такой позицией");
            }
            Node<T> temp = getNode(position);
            if (temp.prev == null) {
                first = temp.next;
            } else {
                temp.prev.next = temp.next;
            }
            if (temp.next == null) {
                last = temp.prev;
            } else {
                temp.next.prev = temp.prev;
            }
            size--;
            return temp.data;
        }

        public T get(int position) {
            if (position < 0 || position >= size) {
                throw new IndexOutOfBoundsException("Нет элемента с такой позицией");
            }
            Node<T> temp = getNode(position);
            return temp.data;
        }

        public int getSize() {
            return size;
        }

        private Node<T> getNode(int position) {
            Node<T> temp;
            if (position < size / 2) {
                temp = first;
                for (int i = 0; i < position; i++) {
                    temp = temp.next;
                }
            } else {
                temp = last;
                for (int i = size - 1; i > position; i--) {
                    temp = temp.prev;
                }
            }
            return temp;
        }
    }
