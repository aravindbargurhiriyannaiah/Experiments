package com.funkyganesha;


import com.funkyganesha.bean.Node;

/**
 * Unbalanced binary search tree
 */
public class BinarySearchTree implements Tree {
    private Node root;

    public void printInOrder(Node root) {
        if (root != null) {
            printInOrder(root.getLeftChild());
            System.out.print(root.getValue() + "\t");
            printInOrder(root.getRightChild());
        }
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

    /**
     * Yet to be implemented.
     *
     * @param value
     * @return
     */
    public boolean delete(int value) {
        boolean result = false;
        if (root != null) {
            Node node = root;
            for (; ; ) {
                if (value == node.getValue()) {
                    result = true;
                    if (node.getRightChild() == null && node.getLeftChild() == null) {
                        //This is a leaf node.

                    }
                    break;
                } else if (value < node.getValue()) {
                    node = node.getLeftChild();
                } else {
                    node = node.getRightChild();
                }
                if (node == null) {
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

    public Node getRootNode() {
        return root;
    }

    public int totalNumberOfNodes(Node root) {
        if (root == null) {
            return 0;
        } else {
            if (Node.isLeaf(root)) {
                return 1;
            } else {
                return (1 + totalNumberOfNodes(root.getLeftChild()) + totalNumberOfNodes(root.getRightChild()));
            }
        }
    }

    public int totalNumberOfLeafNodes(Node root) {
        if (root == null) {
            return 0;
        } else if (Node.isLeaf(root)) {
            return 1;
        } else {
            return totalNumberOfLeafNodes(root.getLeftChild()) + totalNumberOfLeafNodes(root.getRightChild());
        }
    }
}
