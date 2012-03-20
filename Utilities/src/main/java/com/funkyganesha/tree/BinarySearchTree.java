package com.funkyganesha.tree;


import com.funkyganesha.tree.bean.Node;
import com.funkyganesha.tree.util.TreeUtils;

/**
 * Unbalanced binary search tree
 */
public class BinarySearchTree implements Tree {
    private Node root;



    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            root = insert(root, value);
        }
    }

    private Node insert(Node node, int value) {
        Node result = new Node(node);
        if (value < result.getValue()) {
            if (result.getLeftChild() != null) {
                result.setLeftChild(insert(result.getLeftChild(), value));
            } else {
                result.setLeftChild(new Node(value));
            }
        } else {
            if (result.getRightChild() != null) {
                result.setRightChild(insert(result.getRightChild(), value));
            } else {
                result.setRightChild(new Node(value));
            }
        }
        return result;
    }

    public boolean delete(int value) {
        boolean result = false;
        if (root != null) {
            Node current = root;
            Node parent = root;

            for (; ; ) {
                if (value == current.getValue()) {
                    result = true;
                    if (current.getRightChild() == null && current.getLeftChild() == null) {
                        //This is a leaf current.

                    }
                    break;
                } else if (value < current.getValue()) {
                    current = current.getLeftChild();
                } else {
                    current = current.getRightChild();
                }
                if (current == null) {
                    break;
                }
            }
        }
        return result;
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
                break;
            } else if (value <= node.getValue()) {
                if (node.getLeftChild() != null) {
                    node = node.getLeftChild();
                } else {
                    break;
                }
            } else {
                if (node.getRightChild() != null) {
                    node = node.getRightChild();
                } else {
                    break;
                }
            }
        }
        return result;
    }

    public int countAllNodes(Node root) {
        if (root == null) {
            return 0;
        } else {
            if (TreeUtils.isLeafNode(root)) {
                return 1;
            } else {
                return (1 + countAllNodes(root.getLeftChild()) + countAllNodes(root.getRightChild()));
            }
        }
    }

    public int countLeafNodes(Node root) {
        if (root == null) {
            return 0;
        } else if (TreeUtils.isLeafNode(root)) {
            return 1;
        } else {
            return countLeafNodes(root.getLeftChild()) + countLeafNodes(root.getRightChild());
        }
    }

    public void deleteTree() {
        if (root != null) {
            root = null;
        }
    }

    public Node getRootNode() {
        return root;
    }
}
