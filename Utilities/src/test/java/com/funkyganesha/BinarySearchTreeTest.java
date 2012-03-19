package com.funkyganesha;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 *
 */
public class BinarySearchTreeTest {
    private Tree tree;

    @Before
    public void setUp() throws Exception {
        tree = new BinarySearchTree();
    }

    @Test
    public void testInsert() {
        createTree();
        assertEquals("Incorrect number of nodes in the tree.", 3, tree.totalNumberOfNodes(tree.getRootNode()));
    }

    @Test
    public void testDelete_invalidValue() {
    }

    @Test
    public void testDelete_validValue() {
    }

    @Test
    public void testSearch_withValidValue() {
        createTree();
        boolean actual = tree.search(4);
        assertTrue("Should have found the value.", actual);
    }

    @Test
    public void testSearch_withNonExistentValue() {
        createTree();
        boolean actual = tree.search(5);
        assertFalse("Should not have found the value", actual);
    }

    @Test
    public void testTotalNumberOfNodes () {
        createTree();
        int actualNumberOfNodes = tree.totalNumberOfNodes(tree.getRootNode());
        assertEquals("Incorrect total number of nodes in the tree", 3, actualNumberOfNodes);
    }

    @Test
    public void testTotalNumberOfLeafNodes() {
        createTree();
        int actualLeafNodeCount = tree.totalNumberOfLeafNodes(tree.getRootNode());
        assertEquals("Incorrect number of leaf nodes.", 2, actualLeafNodeCount);
    }

    private void createTree() {
        tree.insert(3);
        tree.insert(2);
        tree.insert(4);
        tree.printInOrder(tree.getRootNode());
    }
}
