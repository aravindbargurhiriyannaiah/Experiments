package com.funkyganesha;

import com.funkyganesha.bean.Node;

/**
 * unbalanced binary search tree
 */
public class BinarySearchTree implements Tree {
    private Node root;

    public boolean search(int data) {
        boolean result = false;
        if (root != null) {
            if (data == root.getData()) {
                result = true;
            } else {
                if (data <= root.getData()) {
                    //traverse the left tree
                    return search(data);
                } else {
                    //traverse the right tree
                    return search(data);
                }
            }
        }
        return result;
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node t, int data) {
        if (t == null) {
            t = new Node(data);
        } else if (data < t.getData()) {
            t.setLeft(insert(t.getLeft(), data));
        } else if (data > t.getData()) {
            t.setRight(insert(t.getRight(), data));
        } else {
            //duplicate - do nothing.
        }
        return t;
    }


    public void remove(Node node) {

    }

    public Node getRoot() {
        return root;
    }
}
