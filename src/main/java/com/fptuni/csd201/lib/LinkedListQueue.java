/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.csd201.lib;

import com.fptuni.csd201.ds.Queue;

/**
 *
 * @author DUNGHUYNH
 */
public class LinkedListQueue implements Queue {

    LinkedList list = new LinkedList();

    @Override
    public void enqueue(Node book) {
        list.addToTail(book);
    }

    @Override
    public Node dequeue() {
        return list.deleteFirst();

    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void clear() {
       list.clear();
    }

    // @Override
    // public int first() {
    //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    // }

    // @Override
    // public void traverse() {
    //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    // }
}
