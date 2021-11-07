package com.fptuni.csd201.lib;

import com.fptuni.csd201.object.Book;
// import com.fptuni.csd201.object.Person;

public class Node {

    Book book;
    Node left, right;

    Node() {
    }

    Node(Book book) {
        this.book = book;
        left = null;
        right = null;
    }
}
