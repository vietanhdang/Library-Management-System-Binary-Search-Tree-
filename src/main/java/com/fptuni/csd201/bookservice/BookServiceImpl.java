/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fptuni.csd201.bookservice;

import com.fptuni.csd201.lib.BinaryTree;
import com.fptuni.csd201.object.Book;

/**
 *
 * @author DUNGHUYNH
 */
public class BookServiceImpl implements BookService {

    public static BinaryTree tree = new BinaryTree();

    @Override
    public boolean addBook(Book book) {
        return tree.insert(book);
    }

    @Override
    public void printBook(Book book) {
        if (book != null)
            System.out.println(book.toString());
    }

    @Override
    public void showBook(int method) {
        if (method == 1) {
            tree.inOrder();
        }
        if (method == 2) {
            tree.breadthFirst();
        }
    }

    @Override
    public Book searchBookbyCode(String bookCode) {
        return tree.searchByCode(bookCode);
    }

    @Override
    public int countBook() {
        return tree.count();
    }

    @Override
    public boolean removeBook(String bookCode) {
        return tree.delete(bookCode);
    }

    @Override
    public void printAvailableBook() {
        tree.availableBook();
    }

    @Override
    public void balancing() {
        tree.balance();
    }

    @Override
    public Book searchBookbyName(String name) {
        return tree.searchByName(name);
    }
}
