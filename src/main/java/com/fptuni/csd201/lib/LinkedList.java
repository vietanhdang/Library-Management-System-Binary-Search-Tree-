package com.fptuni.csd201.lib;

public class LinkedList {

    private NodeQ head, tail;

    public LinkedList() {
        head = null;
        tail = null;

    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void clear() {
        head = null;
        tail = null;
    }

    public void addToTail(Node book) {
        NodeQ newNode = new NodeQ(book);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public Node deleteFirst() {
        if (isEmpty()) {
            return null;
        } else {
            Node temp = head.book;
            head = head.next;
            return temp;
        }
    }

    public int count() {
        int count = 0;
        NodeQ node = head;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    public Node getIndex(int index) {
        NodeQ node = head;
        int count = 0;
        while (node != null) {
            if (count == index) {
                return node.book;
            }
            count++;
            node = node.next;
        }
        return null;
    }

}
