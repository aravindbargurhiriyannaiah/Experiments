package com.funkyganesha.tree.util;


import org.apache.commons.lang.math.RandomUtils;
import org.junit.Before;
import org.junit.Test;

import com.funkyganesha.tree.BinarySearchTree;
import com.funkyganesha.tree.Tree;
import com.funkyganesha.tree.bean.Node;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 *
 */
public class TreeUtilsTest {
    private Tree tree;

    @Before
    public void setup() {
        tree = new BinarySearchTree();
        createTestTree(this.tree);
    }

    @Test
    public void testCountAllNodes() {
        assertEquals("The number of nodes in the tree is incorrect", 3, TreeUtils.countAllNodes(tree.getRootNode()));
    }

    @Test
    public void testCountLeafNodes() {
        assertEquals("The number of nodes in the tree is incorrect", 2, TreeUtils.countLeafNodes(tree.getRootNode()));
    }

    @Test
    public void testIfNodeIsALead() {
        Node leafNode = new Node(RandomUtils.nextInt(10));
        assertTrue("Node is a leaf as it does not have children. Should have returned true. ", TreeUtils.isLeafNode(leafNode));
    }

    /**
     * Create a test tree as follows..
     * <pre>
     *              3 ---- root node
     *            / \
     *          2   4 ---- leaf nodes
     * </pre>
     *
     * @param tree
     */
    public static void createTestTree(Tree tree) {
        tree.insert(3);
        tree.insert(2);
        tree.insert(4);
        TreeUtils.displayTree(tree.getRootNode());
    }

    @Test
    public void testTreeDisplayOfALargerTree() {
        tree.deleteTree();
        tree.insert(8);
        tree.insert(6);
        tree.insert(9);
        tree.insert(3);
        tree.insert(7);
        tree.insert(15);
        TreeUtils.displayTree(tree.getRootNode());
    }


}
