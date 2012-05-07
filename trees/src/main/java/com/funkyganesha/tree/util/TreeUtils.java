package com.funkyganesha.tree.util;

import java.util.List;
import java.util.Stack;

import org.apache.commons.collections.CollectionUtils;

import com.funkyganesha.tree.bean.Node;
import com.google.common.collect.Lists;

public class TreeUtils {
    public static boolean isBinarySearchTree(Node node) {
        List<Integer> listFromTree = createListFromTree(node);
        boolean result = true;
        if (CollectionUtils.isNotEmpty(listFromTree)) {
            for (int i = 0; i < listFromTree.size() - 2; i++) {
                if (listFromTree.get(i) > listFromTree.get(i + 1)) {
                    result = false;
                    break;
                }
            }
        } else {
            result = false;
        }
        return result;
    }

    public static List<Integer> createListFromTree(Node node) {
        List<Integer> nodeList = Lists.newArrayList();
        addValuesToTreeInOrder(node, nodeList);
        if (CollectionUtils.isEmpty(nodeList)) {
            nodeList = null;
        }
        return nodeList;
    }

    private static void addValuesToTreeInOrder(Node node, List<Integer> nodeList) {
        if (node != null) {
            addValuesToTreeInOrder(node.getLeftChild(), nodeList);
            nodeList.add(node.getValue());
            addValuesToTreeInOrder(node.getRightChild(), nodeList);
        }
    }

    /**
     * level = 0 means the root node.
     *
     * @param level
     * @param node
     * @return <ol><li>The number of nodes at a given level.</li>
     *         <li>-1 if the level is greater than the height of the root or the root is null.</li></ol>
     */
    public static int countNodesAtLevel(int level, Node node) {
        int noOfNodes = 0;
        int heightOfTheTree = heightOfANode(node);
        if (heightOfTheTree >= level && node != null & level >= 0) {
            level -= 1;
            if (level == -1) {
                noOfNodes++;
            }
            noOfNodes += countNodesAtLevel(level, node.getLeftChild());
            noOfNodes += countNodesAtLevel(level, node.getRightChild());
        }
        return noOfNodes;
    }

    /**
     * level = 0 means the root node. The nodes in the list will be from left to right.
     *
     * @param level
     * @param node
     * @return A list of all the nodes found at a given level. Empty list if none are found.
     */
    public static List<Node> findNodesAtLevel(int level, Node node) {
        List<Node> nodes = Lists.newArrayList();
        int heightOfTheTree = heightOfANode(node);
        if (heightOfTheTree >= level && node != null && level >= 0) {
            level -= 1;
            if (level == -1) {
                nodes.add(node);
            }
            nodes.addAll(findNodesAtLevel(level, node.getLeftChild()));
            nodes.addAll(findNodesAtLevel(level, node.getRightChild()));
        }
        return nodes;
    }

    /**
     * The depth of a tree is the depth of its deepest node (also called as height of a node)
     * <ol> Definitions taken from http://cs.nyu.edu/courses/fall02/V22.0310-002/lectures/lecture-08.html
     * <li>The height of a leaf is 0.</li>
     * <li>The height of an internal node v is 1 plus the maximum height of the children of v.</li>
     * <li>The height of a tree is the height of the root.</li>
     * </ol>
     *
     * @param node
     * @return the length of the longest downward path to a leaf from this node.
     */
    public static int heightOfANode(Node node) {
        if (node == null || TreeUtils.isLeafNode(node)) {
            return 0;
        } else {
            return 1 + Math.max(heightOfANode(node.getLeftChild()), heightOfANode(node.getRightChild()));
        }
    }

    /**
     * The depth of the node is its distance from the root.
     * <ol>
     * <li>The depth of the root is 0.</li>
     * <li>The depth of a node is 1 plus the depth of node's parent.</li>
     * </ol>
     *
     * @param node
     * @return The length of the path from node to the root node.
     */
    public static int depthOfANode(Node node) {
        if (node == null || node.getParent() == null) {
            return 0;
        } else {
            return 1 + depthOfANode(node.getParent());
        }
    }

    /**
     * Traverse the tree in post order and copy the entire tree.
     *
     * @param node
     * @return
     */
    public static Node copyTree(Node node) {
        if (node == null) {
            return null;
        }
        copyTree(node.getLeftChild());
        copyTree(node.getRightChild());
        return new Node(node);
    }

    /**
     * @param node
     * @return the total number of nodes in the tree.
     */
    public static int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            if (isLeafNode(node)) {
                return 1;
            } else {
                return (1 + size(node.getLeftChild()) + size(node.getRightChild()));
            }
        }
    }

    /**
     * @param node
     * @return total number of leaf nodes in the tree.
     */
    public static int countLeafNodes(Node node) {
        if (node == null) {
            return 0;
        } else if (isLeafNode(node)) {
            return 1;
        } else {
            return countLeafNodes(node.getLeftChild()) + countLeafNodes(node.getRightChild());
        }
    }

    public static void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.getLeftChild());
            System.out.print(node + "\n");
            traverseInOrder(node.getRightChild());
        }
    }

    public static void traversePreOrder(Node node) {
        if (node != null) {
            System.out.println(node + "\n");
            traversePreOrder(node.getLeftChild());
            traversePreOrder(node.getRightChild());
        }
    }

    public static void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.getLeftChild());
            traversePostOrder(node.getRightChild());
            System.out.println(node + "\n");
        }
    }

    public static boolean isLeafNode(Node node) {
        return (node != null && node.getLeftChild() == null && node.getRightChild() == null) ? true : false;
    }

    // I picked up this method from the internet - while it works, I have not tried to look into it closely.
    public static void displayTree(Node root) {
        Stack globalStack = new Stack();
        globalStack.push(root);
        //If it is a large tree, increase nBlanks to a larger number. For 3 - 7 nodes, 12 is good enough
        //int nBlanks = 32;
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("-----------------------------------");
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
        System.out.println("-----------------------------------");
    }  // end displayTree()
}
