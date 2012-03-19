package com.funkyganesha;


import com.funkyganesha.bean.Node;

/**
 * Unbalanced binary search tree
 */
public class BinarySearchTree implements Tree {
    private Node root;


    public void traversePreOrder(Tree tree) {

    }

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            root = insert(root, value);
        }
    }

    private Node insert(Node node, int value) {
        Node result = new Node(node);
        if (value <= result.getValue()) {
            if (result.getLeft() != null) {
                result.setLeft(insert(result.getLeft(), value));
            }
        } else {
            if (result.getRight() != null) {
                result.setRight(insert(result.getRight(), value));
            }
        }
        return result;
    }

    public void delete(int value) {

    }

    public boolean search(int value) {
        boolean result = false;
        if (root == null) {
            result = false;
        }
        Node node = root;
        for (; ; ) {
            if (value == node.getValue()) {
                result = true;
            } else if (value <= node.getValue()) {
                if (node.getLeft() != null) {
                    node = node.getLeft();
                } else {
                    break;
                }
            } else {
                if (node.getRight() != null) {
                    node = node.getRight();
                } else {
                    break;
                }
            }
        }
        return result;
    }
}
