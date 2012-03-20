package com.funkyganesha.tree;

import org.junit.Before;
import org.junit.Test;

import com.funkyganesha.tree.util.TreeUtils;
import com.funkyganesha.tree.util.TreeUtilsTest;

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
        TreeUtilsTest.createTestTree(tree);
    }

    @Test
    public void testInsert() {
        assertEquals("Incorrect number of nodes in the tree.", 3, TreeUtils.countAllNodes(tree.getRootNode()));
    }

    @Test
    public void testDelete_invalidValue() {
    }

    @Test
    public void testDelete_validValue() {
    }

    @Test
    public void testSearch_withValidValue() {
        assertTrue("Should have found the value.", tree.search(4));
    }

    @Test
    public void testSearch_withNonExistentValue() {
        assertFalse("Should not have found the value as it does not exist in the test tree.", tree.search(5));
    }

    @Test
    public void testDeleteEntireTree() {
        assertEquals("Incorrect number of nodes in the tree.", 3, TreeUtils.countAllNodes(tree.getRootNode()));
        tree.deleteTree();
        assertEquals("Incorrect number of nodes in the tree", 0, TreeUtils.countAllNodes(tree.getRootNode()));
    }
}
