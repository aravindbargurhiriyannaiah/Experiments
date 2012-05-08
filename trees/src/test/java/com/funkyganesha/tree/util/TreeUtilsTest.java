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
import static junit.framework.Assert.assertFalse;
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

    @Test
    public void testCountNodesAtLevelGreaterThanHeightOfTree() {
        int noOfNodes = TreeUtils.countNodesAtLevel(100, tree.getRootNode());
        assertEquals("Incorrect number of nodes returned for level [" + 100 + "] ", 0, noOfNodes);
    }

    @Test
    public void testCountNodesAtLevelLessThanZero() {
        int noOfNodes = TreeUtils.countNodesAtLevel(-1, tree.getRootNode());
        assertEquals("Incorrect number of nodes returned for level [" + -1 + "] ", 0, noOfNodes);
    }

    @Test
    public void testCountNodesAtLevelWithNodeAsNull() {
        int noOfNodes = TreeUtils.countNodesAtLevel(1, null);
        assertEquals("Incorrect number of nodes returned for level [" + 1 + "]", 0, noOfNodes);
    }

    @Test
    public void testCountNodesAtLevelLargerTree() {
        int level = 0;
        int noOfNodes = TreeUtils.countNodesAtLevel(level, tree.getRootNode());
        assertEquals("Incorrect number of nodes returned for level [" + level + "] ", 1, noOfNodes);
        tree.deleteTree();
        List<Integer> integerList = Lists.newArrayList(8, 3, 10, 1, 6, 4, 7, 14, 13);
        tree.insert(integerList);
        TreeUtils.displayTree(tree.getRootNode());
        level = 2;
        noOfNodes = TreeUtils.countNodesAtLevel(level, tree.getRootNode());
        assertEquals("Incorrect number of nodes returned for level [" + level + "] ", 3, noOfNodes);
        level = 3;
        noOfNodes = TreeUtils.countNodesAtLevel(level, tree.getRootNode());
        assertEquals("Incorrect number of nodes returned for level [" + level + "] ", 3, noOfNodes);
    }

    @Test
    public void testFindNodesAtAllLevelsOfSmallTree() {
        int level = 0;
        List<Node> nodesAtLevel = TreeUtils.findNodesAtLevel(level, tree.getRootNode());
        assertNotNull("The list of nodes should not be null", nodesAtLevel);
        assertEquals("Incorrect number of nodes at level [" + level + "] ", 1, nodesAtLevel.size());
        assertEquals("Invalid node returned for level [" + level + "] ", 3, nodesAtLevel.get(0).getValue());
        nodesAtLevel = TreeUtils.findNodesAtLevel(1, tree.getRootNode());
        assertNotNull("The list of nodes should not be null", nodesAtLevel);
        assertEquals("Incorrect number of nodes at level [" + level + "] ", 2, nodesAtLevel.size());
        assertEquals("Invalid node returned for level [" + level + "] ", 2, nodesAtLevel.get(0).getValue());
        assertEquals("Invalid node returned for level [" + level + "] ", 4, nodesAtLevel.get(1).getValue());
    }

    @Test
    public void testFindNodesAtLevelWithInvalidLevel() {
        int level = 10;
        List<Node> nodesAtLevel = TreeUtils.findNodesAtLevel(level, tree.getRootNode());
        assertNotNull("The list of nodes should not be n ull", nodesAtLevel);
        assertEquals("Incorrect number of nodes at level [" + level + "] ", 0, nodesAtLevel.size());
    }

    @Test
    public void testFindNodesAtLevelOfLargeTree() {
        tree.deleteTree();
        List<Integer> integerList = Lists.newArrayList(8, 3, 10, 1, 6, 4, 7, 14, 13);
        tree.insert(integerList);

        //find node at root.
        int level = 0;
        List<Node> nodesAtLevel = TreeUtils.findNodesAtLevel(level, tree.getRootNode());
        assertEquals("Incorrect number of nodes at level [" + level + "] ", 1, nodesAtLevel.size());
        assertEquals("Invalid node returned for level [" + level + "] ", 8, nodesAtLevel.get(0).getValue());
        
        level = 1;
        nodesAtLevel = TreeUtils.findNodesAtLevel(level, tree.getRootNode());
        assertEquals("Incorrect number of nodes at level [" + level + "] ", 2, nodesAtLevel.size());
        assertEquals("Invalid node returned for level [" + level + "] ", 3, nodesAtLevel.get(0).getValue());
        assertEquals("Invalid node returned for level [" + level + "] ", 10, nodesAtLevel.get(1).getValue());

        level = 2;
        nodesAtLevel = TreeUtils.findNodesAtLevel(level, tree.getRootNode());
        assertEquals("Incorrect number of nodes at level [" + level + "] ", 3, nodesAtLevel.size());
        assertEquals("Invalid node returned for level [" + level + "] ", 1, nodesAtLevel.get(0).getValue());
        assertEquals("Invalid node returned for level [" + level + "] ", 6, nodesAtLevel.get(1).getValue());
        assertEquals("Invalid node returned for level [" + level + "] ", 14, nodesAtLevel.get(2).getValue());

        level = 3;
        nodesAtLevel = TreeUtils.findNodesAtLevel(level, tree.getRootNode());
        assertEquals("Incorrect number of nodes at level [" + level + "] ", 3, nodesAtLevel.size());
        assertEquals("Invalid node returned for level [" + level + "] ", 4, nodesAtLevel.get(0).getValue());
        assertEquals("Invalid node returned for level [" + level + "] ", 7, nodesAtLevel.get(1).getValue());
        assertEquals("Invalid node returned for level [" + level + "] ", 13, nodesAtLevel.get(2).getValue());
    }

    @Test
    public void testCreateListFromTreeWithNull() {
        List<Integer> listFromTree = TreeUtils.createListFromTree(null);
        assertNull("The result should be null", listFromTree);
    }

    @Test
    public void testCreateListFromTreeWithValidBinarySearchTree() {
        List<Integer> listFromTree = TreeUtils.createListFromTree(tree.getRootNode());
        assertNotNull("The result should not be null", listFromTree);
        assertEquals("Incorrect size", 3, listFromTree.size());
        assertEquals("Incorrect value", new Integer(2),listFromTree.get(0));
        assertEquals("Incorrect value", new Integer(3),listFromTree.get(1));
        assertEquals("Incorrect value", new Integer(4),listFromTree.get(2));
    }

    @Test
    public void testIsBinarySearchTreeWithNull() {
        boolean binarySearchTree = TreeUtils.isBinarySearchTree(null);
        assertFalse("The tree is not a valid binary search tree. The result should have been false.", binarySearchTree);
    }

    @Test
    public void testIsBinarySearchTreeWithValidTree() {
        boolean binarySearchTree = TreeUtils.isBinarySearchTree(tree.getRootNode());
        assertTrue("The tree is a valid binary search tree. The result should have been true.", binarySearchTree);
    }

    @Test
    public void testIsBinarySearchTreeWithInvalidBinarySearchTree() {
        Node root = new Node(4);
        Node left = new Node(5);
        Node right = new Node(6);
        root.setLeftChild(left);
        root.setRightChild(right);
        boolean binarySearchTree = TreeUtils.isBinarySearchTree(root);
        assertFalse("The tree is not a valid binary search tree. The result should have been false.", binarySearchTree);
    }

    @Test
    public void testBreadthFirstSearchWithNullNode() {
        Node node = TreeUtils.breadthFirstSearch(null, 3);
        assertNull("The result should be null.", node);
    }

    @Test
    public void testBreadthFirstSearch() {
        Node node = TreeUtils.breadthFirstSearch(tree.getRootNode(), 4);
        assertNotNull("The result should not be null", node);
        assertEquals("Incorrect value for the node returned.", 4, node.getValue());
    }

    @Test
    public void testBreadthFirstSearchWithUnavailableNode() {
        tree.deleteTree();
        List<Integer> integerList = Lists.newArrayList(8, 3, 10, 1, 6, 4, 7, 14, 13);
        tree.insert(integerList);
        Node node = TreeUtils.breadthFirstSearch(tree.getRootNode(), 5);
        assertNull("The result should be null.", node);
    }

    @Test
    public void testDepthFirstSearchWithNullNode() {
        Node node = TreeUtils.depthFirstSearch(null, -1);
        assertNull("The result should be null", node);
    }

    @Test
    public void testDepthFirstSearchUnavailable() {
        tree.deleteTree();
        List<Integer> integerList = Lists.newArrayList(8, 3, 10, 1, 6, 4, 7, 14, 13);
        tree.insert(integerList);
        Node node = TreeUtils.depthFirstSearch(tree.getRootNode(), 5);
        assertNull("The result should be null.", node);
    }

    @Test
    public void testDepthFirstSearchAvailable() {
        tree.deleteTree();
        List<Integer> integerList = Lists.newArrayList(8, 3, 10, 1, 6, 4, 7, 14, 13);
        tree.insert(integerList);
        Node node = TreeUtils.depthFirstSearch(tree.getRootNode(), 14);
        assertNotNull("The result should not be null.", node);
        assertEquals("Invalid node returned", 14, node.getValue());
    }
}
