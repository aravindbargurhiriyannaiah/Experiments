package com.funkyganesha.bean;

/**
 *
 */
public class Node {
    private int value;
    private Node leftChild;
    private Node rightChild;

    public Node(int value) {
        this.value = value;
    }

    public Node(Node node) {
        this.value = node.value;
        this.leftChild = node.getLeftChild();
        this.rightChild = node.getRightChild();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node left) {
        this.leftChild = left;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node right) {
        this.rightChild = right;
    }

    public static boolean isLeaf(Node node) {
        return (node != null && node.getLeftChild() == null && node.getRightChild() == null) ? true : false;
    }
}
