/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.csd201.ds;

import com.fptuni.csd201.lib.Node;

/**
 *
 * @author DUNGHUYNH
 */
public interface Queue {

    boolean isEmpty();

    void clear();//  - clear the queue.

    void enqueue(Node x);//` - insert  a node with value  x  at the end of  the queue.

    Node dequeue();// - remove the first element on the queue and return it's value; throw Exception for empty queue.

    // int first();// -  return value of  the first node of the queue; throw Exception for empty queue.

    // void traverse();
}
