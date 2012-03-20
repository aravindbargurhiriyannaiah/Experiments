package com.funkyganesha.tree.util;

import java.util.Stack;

import com.funkyganesha.tree.bean.Node;

/**
 *
 */
public class TreeUtils {
    public static int countAllNodes(Node root) {
        if (root == null) {
            return 0;
        } else {
            if (isLeafNode(root)) {
                return 1;
            } else {
                return (1 + countAllNodes(root.getLeftChild()) + countAllNodes(root.getRightChild()));
            }
        }
    }

    public static int countLeafNodes(Node root) {
        if (root == null) {
            return 0;
        } else if (isLeafNode(root)) {
            return 1;
        } else {
            return countLeafNodes(root.getLeftChild()) + countLeafNodes(root.getRightChild());
        }
    }

    public static void traverseInOrder(Node root) {
        if (root != null) {
            traverseInOrder(root.getLeftChild());
            System.out.print(root + "\n");
            traverseInOrder(root.getRightChild());
        }
    }

    public static void traversePreOrder(Node root) {
        if (root != null) {
            System.out.println(root + "\n");
            traversePreOrder(root.getLeftChild());
            traversePreOrder(root.getRightChild());
        }
    }

    public static void traversePostOrder(Node root) {
        if (root != null) {
            traversePostOrder(root);
            traversePostOrder(root.getRightChild());
            System.out.println(root + "\n");
        }
    }

    public static boolean isLeafNode(Node node) {
        return (node != null && node.getLeftChild() == null && node.getRightChild() == null) ? true : false;
    }

    public static void displayTree(Node root) {
        Stack globalStack = new Stack();
        globalStack.push(root);
        //If it is a large tree, increase nBlanks to a larger number. For 3 - 7 nodes, 12 is good enough
        //int nBlanks = 32;

        int nBlanks = 12;
        boolean isRowEmpty = false;
        System.out.println("......................................................");
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;
            for (int j = 0; j < nBlanks; j++) {
                System.out.print(' ');
            }
            while (globalStack.isEmpty() == false) {
                Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.getValue());
                    localStack.push(temp.getLeftChild());
                    localStack.push(temp.getRightChild());
                    if (temp.getLeftChild() != null || temp.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(' ');
                }
            }  // end while globalStack not empty
            System.out.println();
            nBlanks /= 2;
            while (localStack.isEmpty() == false) {
                globalStack.push(localStack.pop());
            }
        }  // end while isRowEmpty is false
        System.out.println("......................................................");
    }  // end displayTree()
}
