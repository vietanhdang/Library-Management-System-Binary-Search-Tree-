package com.fptuni.csd201.lib;

public class NodeQ {
    NodeQ next;
    Node book;

    public NodeQ(Node book) {
        this.book = book;
        this.next = null;
    }
}
