/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.csd201.lib;

import com.fptuni.csd201.object.Book;

/**
 *
 * @author DUNGHUYNH
 */
public class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(Node root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void visit(Node node) {
        if (node != null) {
            System.out.println(node.book.toString());
        }
    }

    public void preOrder(Node node) {
        if (node != null) {
            visit(node);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            visit(node);
            inOrder(node.right);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            visit(node);
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    public void breadthFirst(Node node) {
        LinkedListQueue queue = new LinkedListQueue();
        queue.enqueue(node);
        while (!queue.isEmpty()) {
            Node cur = queue.dequeue();
            visit(cur);
            if (cur.left != null) {
                queue.enqueue(cur.left);
            }
            if (cur.right != null) {
                queue.enqueue(cur.right);
            }
        }
    }

    public void breadthFirst() {
        breadthFirst(root);
    }

    public boolean insert(Book book) {
        Node node = new Node(book);
        if (isEmpty()) {
            root = node;
        } else {
            Node cu = root;
            Node f = null;
            while (cu != null) {
                if (cu.book.getCode().equalsIgnoreCase(book.getCode())) {
                    return false;
                } else {
                    f = cu;
                    cu = (cu.book.getCode().compareToIgnoreCase(book.getCode()) < 0) ? cu.right : cu.left;
                }
            }
            if (f.book.getCode().compareToIgnoreCase(book.getCode()) < 0) {
                f.right = node;
            } else {
                f.left = node;
            }
        }
        return true;
    }

    public Node _searchByCode(String bookCode) {
        Node cur = root;
        while (cur != null) {
            if (cur.book.getCode().equalsIgnoreCase(bookCode)) {
                return cur;
            } else {
                cur = (cur.book.getCode().compareToIgnoreCase(bookCode) < 0) ? cur.right : cur.left;
            }
        }
        return null;
    }

    public Book searchByCode(String bookCode) {
        Node found = _searchByCode(bookCode);
        return found == null ? null : found.book;
    }

    public int count() {
        int total = 0;
        LinkedListQueue queue = new LinkedListQueue();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node cur = queue.dequeue();
            total++;
            if (cur.left != null) {
                queue.enqueue(cur.left);
            }
            if (cur.right != null) {
                queue.enqueue(cur.right);
            }
        }
        return total;
    }

    public Node findFather(String code) {
        Node cu = root;
        Node f = null;
        while (cu != null) {
            if (cu.book.getCode().equalsIgnoreCase(code)) {
                return f;
            } else {
                f = cu;
                cu = (cu.book.getCode().compareToIgnoreCase(code) < 0) ? cu.right : cu.left;
            }
        }
        return null;
    }

    public boolean delete(String bookCode) {
        Node p = _searchByCode(bookCode);
        if (p == null) {
            return false;
        } else {
            if (p.left == null && p.right == null) {
                Node father = findFather(bookCode);
                if (father == null) {
                    p = null;
                } else {
                    if (father.left == p) {
                        father.left = null;
                    } else {
                        father.right = null;
                    }
                }
            } else {
                if (p.right == null) {
                    if (p.left.right == null) {
                        p.book = p.left.book;
                        p.left = p.left.left;
                    } else {
                        Node f = p.left;
                        Node cu = p.left.right;
                        while (cu.right != null) {
                            f = cu; // Cha node ngoai cung ben phai cua con trai
                            cu = cu.right; // Tim node ngoai be phai cua con trai
                        }
                        p.book = cu.book;
                        f.right = cu.left;
                    }
                } else {
                    if (p.right.left == null) {
                        p.book = p.right.book;
                        p.right = p.right.right;
                    } else {
                        Node f = p.right;
                        Node cu = p.right.left;
                        while (cu.left != null) {
                            f = cu; // Cha node ngoai cung ben phai cua con trai
                            cu = cu.left; // Tim node ngoai be phai cua con trai
                        }
                        p.book = cu.book;
                        f.left = cu.right;
                    }
                }
            }
            return true;
        }
    }

    public void buildArray(LinkedList a, Node p) {
        if (p == null) {
            return;
        }
        buildArray(a, p.left);
        a.addToTail(p);
        buildArray(a, p.right);
    }

    /**
     * This method insert all items from an array to a new binary tree
     *
     * @param a
     * @param f
     * @param l
     */
    public void balance(LinkedList a, int f, int l) {
        if (f > l) {
            return;
        }
        int m = (f + l) / 2;
        Node p = a.getIndex(m);
        insert(p.book);
        balance(a, f, m - 1);
        balance(a, m + 1, l);
    }

    /**
     * This method create tree and insert
     *
     * @param p is a node of the binary tree
     */
    public void _balance(Node p) {
        LinkedList a = new LinkedList();
        buildArray(a, p);
        int l = a.count(), f = 0;
        // create a new tree and insert all items from a to the BST
        BinaryTree t = new BinaryTree();
        t.balance(a, f, l - 1);
        root = t.root;
    }

    /**
     * This method
     */
    public void balance() {
        _balance(root);
    }

    public void availableBook(Node node) {
        if (node != null) {
            inOrder(node.left);
            if (node.book.getLended() < node.book.getQuantity()) {
                visit(node);
            }
            inOrder(node.right);
        }
    }

    public void availableBook() {
        availableBook(root);
    }

    public Book searchByName(String name) {
        Node cur = root;
        while (cur != null) {
            if (cur.book.getName().equalsIgnoreCase(name)) {
                return cur.book;
            } else {
                cur = (cur.book.getName().compareToIgnoreCase(name) < 0) ? cur.right : cur.left;
            }
        }
        return null;
    }

}
