package com.funkyganesha.tree.util;


import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.math.RandomUtils;
import org.junit.Before;
import org.junit.Test;

import com.funkyganesha.tree.BinarySearchTree;
import com.funkyganesha.tree.Tree;
import com.funkyganesha.tree.bean.Node;
import com.google.common.collect.Lists;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;

public class TreeUtilsTest {
    private Tree tree;

    @Before
    public void setup() {
        tree = new BinarySearchTree();
        createTestTree(this.tree);
    }

    @Test
    public void testCountAllNodes() {
        assertEquals("The number of nodes in the tree is incorrect", 3, TreeUtils.size(tree.getRootNode()));
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

    @Test
    public void testThatRootNodesParentIsNull() {
        Node rootNode = new Node(RandomUtils.nextInt(10));
        assertNull("This node does not have a parent. Parent should be null.", rootNode.getParent());
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
        tree.deleteTree();
        tree.insert(Arrays.asList(3, 2, 4));
//        TreeUtils.displayTree(tree.getRootNode());
    }

    @Test
    public void testTreeDisplayOfALargerTree() {
        tree.deleteTree();
        tree.insert(Arrays.asList(8, 6, 9, 3, 7, 15));
//        TreeUtils.displayTree(tree.getRootNode());
    }

    @Test
    public void createTestTreeWithDuplicates() {
        tree.deleteTree();
        tree.insert(Arrays.asList(8, 6, 13, 13, 17, 17));
//        TreeUtils.displayTree(tree.getRootNode());
    }

    @Test
    public void testHeightOfANodeWithNull() {
        int depth = TreeUtils.heightOfANode(null);
        assertEquals("Invalid depth returned", 0, depth);
    }

    @Test
    public void testHeightOfANodeWithValidTree() {
        tree.deleteTree();
        List<Integer> integerList = Lists.newArrayList(8, 3, 10, 1, 6, 4, 7, 14, 13);
        tree.insert(integerList);
        int height = TreeUtils.heightOfANode(tree.getRootNode());
        assertEquals("Invalid height returned", 3, height);
        height = TreeUtils.heightOfANode(tree.getRootNode().getRightChild());
        assertEquals("Invalid height returned", 2, height);
    }

    @Test
    public void sanityCheckForEntireTree() {
        tree.deleteTree();
        List<Integer> integerList = Lists.newArrayList(8, 3, 10, 1, 6, 4, 7, 14, 13);
        tree.insert(integerList);
        Node rootNode = tree.getRootNode();
        int size = TreeUtils.size(rootNode);
        assertEquals("Invalid size of the tree.", 9, size);
        int rootNodeValue = rootNode.getValue();
        assertEquals("Invalid root node returned.", 8, rootNodeValue);
        int leafNodeCount = TreeUtils.countLeafNodes(rootNode);
        assertEquals("Incorrect number of leaf nodes returned", 4, leafNodeCount);
    }

    @Test
    public void testHeightOfALeafNode() {
        int height = TreeUtils.heightOfANode(tree.getRootNode().getLeftChild());
        assertEquals("Invalid height returned", 0, height);
    }

    @Test
    public void testDepthOfANodeWithNull() {
        int depth = TreeUtils.depthOfANode(null);
        assertEquals("Invalid depth returned.", 0, depth);
    }

    @Test
    public void testDepthOfNodeWithRootNode() {
        int depth = TreeUtils.depthOfANode(tree.getRootNode());
        assertEquals("Invalid depth returned", 0, depth);
    }

    @Test
    public void testDepthOfNodeWithSomeNode() {
        int depth = TreeUtils.depthOfANode(tree.getRootNode().getRightChild());
        assertEquals("Invalid depth returned", 1, depth);
    }

    @Test
    public void testCopyTree() {
        Node newRoot = TreeUtils.copyTree(tree.getRootNode());
        Tree newTree = new BinarySearchTree(newRoot);
        Tree existingTree = tree;
        assertNotNull("The new tree should not be null", newTree);
        Node existingTreeRootNode = existingTree.getRootNode();
        Node newTreeRootNode = newTree.getRootNode();
        assertEquals("Invalid size of the new tree", TreeUtils.size(existingTreeRootNode), TreeUtils.size(newTreeRootNode));
        assertEquals("Invalid number of leaf nodes", TreeUtils.countLeafNodes(existingTreeRootNode), TreeUtils.countLeafNodes(newTreeRootNode));
        assertEquals("Invalid root node", existingTreeRootNode.getValue(), newTreeRootNode.getValue());
        boolean delete = existingTree.delete(2);
        assertTrue("The node should have been deleted", delete);
        assertEquals("Invalid size of the new tree", 3, TreeUtils.size(newTreeRootNode));
        Node node = newTree.find(2);
        assertNotNull("Node should not be null", node);
    }

    @Test
    public void testCopyTreeWithNull() {
        Node node = TreeUtils.copyTree(null);
        assertNull("The new tree root should have been null", node);
    }
}
