package com.funkyganesha.tree;


import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.funkyganesha.tree.bean.Node;
import com.funkyganesha.tree.util.TreeUtils;

/**
 * Unbalanced sorted binary search tree - implemented based on http://courses.csail.mit.edu/6.006/spring11/rec/rec03.pdf
 */
public class BinarySearchTree implements Tree {
    private Node root;

    public BinarySearchTree() {
    }

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    @Override
    public void insert(List<Integer> integers) {
        if (CollectionUtils.isNotEmpty(integers)) {
            for (Integer integer : integers) {
                insert(integer);
            }
        }
    }

    @Override
    public void insert(int value) {
        //construct the node to be inserted.
        Node node = new Node(value);
        Node x = getRootNode();
        //find where to insert the new node.
        while (x != null) {
            node.setParent(x);
            if (node.getValue() < x.getValue()) {
                x = x.getLeftChild();
            } else {
                x = x.getRightChild();
            }
        }
        if (node.getParent() == null) {
            //the tree is empty and this is the first node.
            root = node;
        } else if (node.getValue() < node.getParent().getValue()) {
            //insert the node
            node.getParent().setLeftChild(node);
        } else {
            //insert the node. This is a property that we will use while deleting duplicates. A duplicate node will always be on the right sub-tree of a node.
            node.getParent().setRightChild(node);
        }
    }

    @Override
    public Node find(int value) {
        Node result = root;
        while (result != null && result.getValue() != value) {
            if (value < result.getValue()) {
                result = result.getLeftChild();
            } else {
                result = result.getRightChild();
            }
        }
        return result;
    }

    @Override
    public Node findNextLarger(int value) {
        Node result = null;
        Node x = find(value);
        if (x != null) {
            if (x.getRightChild() != null) {
                //x has a right sub-tree that are all larger than x.value. The next larger value of x.value is the minimum key in the right sub-tree.
                result = findMin(x.getRightChild());
            } else {
                //x has no right sub-tree. Traverse up the tree until we reach a node that is the left child. That node's parent will contain the next larger key
                Node parent = x.getParent();
                while ((parent != null) && (x.getValue() == parent.getRightChild().getValue())) {
                    x = parent;
                    parent = parent.getParent();
                }
                result = parent;
            }
        }
        return result;
    }

    @Override
    public Node findNextSmaller(int value) {
        Node result = null;
        Node x = find(value);
        if (x != null) {
            if (x.getLeftChild() != null) {
                //x has a left sub-tree that are all smaller than x.value. The next smaller value of x.value is the minimum key in the left sub-tree.
                result = findMin(x.getLeftChild());
            } else {
                //x does not have a left sub-tree. Traverse up the tree until we reach a node that is the right child. That node's parent will contain the next smaller key
                Node parent = x.getParent();
                while ((parent != null) && (x.getValue() == parent.getLeftChild().getValue())) {
                    x = parent;
                    parent = parent.getParent();
                }
                result = parent;
            }
        }
        return result;
    }

    public boolean delete(int value) {
        boolean result = true;
        //Find the node to be deleted
        Node x = find(value);
        if (x == null) {
            //Cannot delete an unavailable node.
            result = false;
        } else {
            Node parent = x.getParent();
            if (TreeUtils.isLeafNode(x)) {
                //this is a leaf node. simply delete it by setting the parent node's left or right child to null
                if (parent != null) {
                    if (parent.getRightChild().getValue() == x.getValue()) {
                        parent.setRightChild(null);
                    } else {
                        parent.setLeftChild(null);
                    }
                }
            } else if (x.getLeftChild() == null) {
                //The node has only a right sub-tree.
                Node replacementNode = x.getRightChild();
                if (parent.getRightChild().getValue() == x.getValue()) {
                    parent.setRightChild(replacementNode);
                } else {
                    parent.setLeftChild(replacementNode);
                }
            } else if (x.getRightChild() == null) {
                //The node has only a left sub-tree.
                Node replacementNode = x.getLeftChild();
                if (parent.getLeftChild().getValue() == x.getValue()) {
                    parent.setLeftChild(replacementNode);
                } else {
                    parent.setRightChild(replacementNode);
                }
            } else {
                //The node has both left and right sub-trees
                Node y = findNextLarger(x.getValue());
                if (y != null) {
                    parent = y.getParent();
                    Node parentLeftChild = parent.getLeftChild();
                    if ((parentLeftChild != null) && (parentLeftChild.getValue() == y.getValue())) {
                        parent.setLeftChild(y.getRightChild());
                    } else {
                        parent.setRightChild(y.getRightChild());
                    }
                    x.setValue(y.getValue());
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

    @Override
    public void deleteDuplicateNodes() {
        Node x = getRootNode();
        if (x != null) {
            deleteDuplicateNodes(x);
        }
    }

    @Override
    public void deleteDuplicateNodes(Node node) {
        if (node != null) {
            deleteDuplicateNodes(node.getLeftChild());
            deleteDuplicateNodes(node.getRightChild());
            if (!TreeUtils.isLeafNode(node) && (node.getRightChild() != null)) {
                // Owing to the way the nodes are inserted (into a sorted binary search tree), if there is a duplicate, it will be the node's right child.
                if (node.getValue() == node.getRightChild().getValue()) {
                    delete(node.getValue());
                }
            }
        }
    }

    @Override
    public boolean deleteMin() {
        Node min = findMin();
        return deleteMin(min);
    }

    @Override
    public boolean deleteMin(Node node) {
        Node x = node;
        if (x != null) {
            Node min = findMin(x);
            if (min != null) {
                return delete(min.getValue());
            }
        }
        return false;
    }

    @Override
    public boolean deleteMax() {
        Node max = findMax();
        return deleteMax(max);
    }

    @Override
    public boolean deleteMax(Node node) {
        Node x = node;
        if (x != null) {
            Node max = findMax(x);
            if (max != null) {
                return delete(max.getValue());
            }
        }
        return false;
    }

    @Override
    public Node findMin() {
        Node x = root;
        return findMin(x);
    }

    @Override
    public Node findMin(Node node) {
        Node x = node;
        if (x != null) {
            //traverse the left sub-tree until you reach the leaf node - this is the minimum
            while (x.getLeftChild() != null) {
                x = x.getLeftChild();
            }
        }
        return x;
    }

    @Override
    public Node findMax() {
        Node x = root;
        return findMax(x);
    }

    @Override
    public Node findMax(Node node) {
        Node x = node;
        if (x != null) {
            //traverse the right sub-tree until you reach the leaf node - this is the maximum
            while (x.getRightChild() != null) {
                x = x.getRightChild();
            }
        }
        return x;
    }

    public Node getRootNode() {
        return root;
    }
}
