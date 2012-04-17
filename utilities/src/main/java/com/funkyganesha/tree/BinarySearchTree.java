package com.funkyganesha.tree;


import com.funkyganesha.tree.bean.Node;

/**
 * Unbalanced binary search tree
 */
public class BinarySearchTree implements Tree {
    private Node root;

    public void insert(int value) {
        Node result = new Node(value);
        if (root == null) {
            root = result;
        } else {
            root = insert(root, value);
        }
    }

    private Node insert(Node node, int value) {
        Node currentNode = new Node(node);
        if (value < currentNode.getValue()) {
            if (currentNode.getLeftChild() != null) {
                currentNode.setLeftChild(insert(currentNode.getLeftChild(), value));
            } else {
                currentNode.setLeftChild(new Node(value));
            }
        } else {
            if (currentNode.getRightChild() != null) {
                currentNode.setRightChild(insert(currentNode.getRightChild(), value));
            } else {
                currentNode.setRightChild(new Node(value));
            }
        }
        return currentNode;
    }

    public boolean delete(int value) {
        if (root != null) {
            return false;
        } else {
            if (value == root.getValue()) {
                Node dummyNode = new Node(0);
                dummyNode.setLeftChild(root);
                boolean result = delete(value, dummyNode);
                root = dummyNode.getLeftChild();
                return result;
            } else {
                return delete(value, null);
            }
        }
    }

    public boolean delete(int value, Node node) {
        return false;
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
            } else if (value < node.getValue()) {
                if (node.getLeftChild() != null) {
                    node = node.getLeftChild();
                } else {
                    //End of left subtree.
                    break;
                }
            } else {
                if (node.getRightChild() != null) {
                    node = node.getRightChild();
                } else {//End of right subtree.
                    break;
                }
            }
        }
        return result;
    }

    public void deleteTree() {
        if (root != null) {
            root = null;
        }
    }

    public void removeDuplicates() {

    }

    public void deleteMin() {

    }

    public void deleteMax() {

    }


    public int findMin() {
        if (root == null) {
            return -1;
        } else {
            return findMin(root);
        }
    }

    private int findMin(Node root) {
        if (root.getLeftChild() != null) {
            return findMin(root.getLeftChild());
        } else {
            return root.getValue();
        }
    }

    public int findMax() {
        if (root == null) {
            return -1;
        } else {
            return findMax(root);
        }
    }

    private int findMax(Node root) {
        if (root.getRightChild() != null) {
            return findMax(root.getRightChild());
        } else {
            return root.getValue();
        }
    }

    public Node getRootNode() {
        return root;
    }
}
