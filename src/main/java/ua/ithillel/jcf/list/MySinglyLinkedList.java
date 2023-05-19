package ua.ithillel.jcf.list;

import java.util.Iterator;

public class MySinglyLinkedList<T> implements MyList<T> {
    private Node<T> head;
    private int size;

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void add(T el) {
        Node<T> newNode = new Node<>(el);
        // head -> 3 -> 4 -> 8 -> 10
        // 1 -> 3 -> 4 -> 8 -> 10
        // head/
        newNode.next = head;
        // 1 -> 3 -> 4 -> 8 -> 10
        // |
        // head
        head = newNode;
        size++;
    }

    public void addToEnd(T el) {
        Node<T> newNode = new Node<>(el);
        if (head == null) {
            head = newNode;
            return;
        }
        Node<T> curNode = head;
        while (curNode.next != null) {
            curNode = curNode.next;
        }

        curNode.next = newNode;
    }

    @Override
    public T get(int i) {
        if (i >= size) {
            return null;
        }

        int count = i;

        Node<T> curNode = head;
        while (curNode != null) {
            if (count == 0) {
                return curNode.value;
            }

            count--;
            curNode = curNode.next;
        }

        return null;
    }

    @Override
    public T remove(int i) {
        // head -> 3 -> 4 -> 8 -> 10

        //  head -> 3 -> 4 -> 10
        //                 8 /

        //  head -> 3 -> 4 -> 10
        //                 8 -> * NULL

        int count = i;
        Node<T> curNode = head;
        Node<T> prevNode = head;

        while (curNode != null) {
            if (count == 0) {
                Node<T> nodeToDelete = curNode;
                if (nodeToDelete == head) {
                    head = nodeToDelete.next;
                } else {
                    prevNode.next = nodeToDelete.next;
                }
                nodeToDelete.next = null;
                size--;
                return nodeToDelete.value;
            }

            count--;
            prevNode = curNode;
            curNode = curNode.next;
        }

        return null;
    }

    @Override
    public void set(int i, T el) {

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new MySinglyLinkedListIterator();
    }

    private class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    private class MySinglyLinkedListIterator implements Iterator<T> {
        private Node<T> curNode = head;

        @Override
        public boolean hasNext() {
            return curNode != null;
        }

        @Override
        public T next() {
            T value = curNode.value;
            curNode = curNode.next;
            return value;
        }
    }
}
