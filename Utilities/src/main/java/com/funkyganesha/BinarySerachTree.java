package com.funkyganesha;


import com.funkyganesha.bean.Node;

/**
 * Unbalanced binary search tree
 */
public class BinarySerachTree implements Tree {
    private Node root;


    public void traversePreOrder(Tree tree) {

    }

    public void add(int value) {
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

    public void delete(Node node) {

    }

    public Node search(int value) {
        return null;
    }
}
