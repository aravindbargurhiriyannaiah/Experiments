package com.funkyganesha.tree;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.funkyganesha.tree.bean.Node;
import com.funkyganesha.tree.util.TreeUtils;
import com.funkyganesha.tree.util.TreeUtilsTest;
import com.google.common.collect.Lists;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
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
    public void testDeleteInvalidValue() {
        boolean delete = tree.delete(100);
        assertNotNull("The root should not be null. There should be values.", tree.getRootNode());
        assertFalse("Cannot delete the node as the node is unavailable.", delete);
    }

    @Test
    public void testDeleteOnNullTree() {
        tree.deleteTree();
        boolean delete = tree.delete(100);
        assertFalse("Cannot delete the node as the node is unavailable.", delete);
    }

    @Test
    public void testDeleteOnNodeWithOnlyRightChild() {
        tree.deleteTree();
        List<Integer> integers = Lists.newArrayList(23, 8, 4, 16, 17, 19, 42, 39);
        tree.insert(integers);
        boolean delete = tree.delete(16);
        assertTrue("Node should have been deleted", delete);
        Node node = tree.find(16);
        assertNull("Node should not be there. The result is null", node);
    }

    @Test
    public void testDeleteOnNodeWithOnlyLeftChild() {
        tree.deleteTree();
        List<Integer> integers = Lists.newArrayList(23, 8, 4, 16, 17, 42, 39);
        tree.insert(integers);
        boolean delete = tree.delete(42);
        assertTrue("Node should have been deleted", delete);
        Node node = tree.find(42);
        assertNull("The value should have been deleted.", node);
    }

    @Test
    public void testDeleteNodeWithOnlyLeftChild_2() {
        tree.deleteTree();
        List<Integer> integers = Lists.newArrayList(23, 8, 4, 16, 17, 42, 39, 31);
        tree.insert(integers);
        boolean delete = tree.delete(39);
        assertTrue("Node should have been deleted", delete);
        Node node = tree.find(39);
        assertNull("The value should have been deleted.", node);
    }

    @Test
    public void testDeleteNodeWithTwoChildren_1() {
        tree.deleteTree();
        List<Integer> integers = Lists.newArrayList(23, 8, 4, 16, 17, 42, 39, 31);
        tree.insert(integers);
        boolean delete = tree.delete(8);
        assertTrue("Node should have been deleted", delete);
        Node node = tree.find(8);
        assertNull("The value should have been deleted.", node);
    }

    @Test
    public void testDeleteNodeWithTwoChildren_2() {
        tree.deleteTree();
        List<Integer> integers = Lists.newArrayList(23, 8, 4, 17, 15, 16, 42);
        tree.insert(integers);
        boolean delete = tree.delete(8);
        assertTrue("Node should have been deleted", delete);
        Node node = tree.find(8);
        assertNull("Node should have been deleted. It should be null.", node);
    }

    @Test
    public void testDeleteLeafNode() {
        tree.deleteTree();
        tree.insert(Arrays.asList(5, 2, -4, 3, 18));
        boolean delete = tree.delete(-4);
        assertTrue("Node should have been deleted", delete);
        Node node = tree.find(-4);
        assertNull("Node should have been deleted. It should be null.", node);
    }

    @Test
    public void testDeleteNodeWithOneChild() {
        tree.deleteTree();
        List<Integer> integers = Arrays.asList(5, 2, -4, 3, 18, 21, 19, 25);
        tree.insert(integers);
        boolean delete = tree.delete(18);
        assertTrue("Node should have been deleted", delete);
        assertEquals("Incorrect number of nodes in tree.", integers.size() - 1, TreeUtils.countAllNodes(tree.getRootNode()));
        Node node = tree.find(18);
        assertNull("Node should have been deleted. It should be null.", node);
    }

    @Test
    public void testDeleteNodeWithTwoChildren_example1() {
        tree.deleteTree();
        List<Integer> integers = Arrays.asList(5, 2, -4, 3, 12, 9, 21, 19, 25);
        tree.insert(integers);
        boolean delete = tree.delete(12);
        assertTrue("Node should have been deleted", delete);
        assertEquals("Incorrect number of nodes in tree.", integers.size() - 1, TreeUtils.countAllNodes(tree.getRootNode()));
        Node node = tree.find(12);
        assertNull("Node should have been deleted. It should be null.", node);
    }

    @Test
    public void testDeleteNodeWithTwoChildren_example2() {
        tree.deleteTree();
        List<Integer> integers = Arrays.asList(13, 9, 5, 12, 16, 15, 19, 14);
        tree.insert(integers);
        boolean delete = tree.delete(13);
        assertTrue("Node should have been deleted", delete);
        assertEquals("Incorrect number of nodes in tree.", integers.size() - 1, TreeUtils.countAllNodes(tree.getRootNode()));
        Node node = tree.find(13);
        assertNull("Node should have been deleted. It should be null.", node);
    }

    @Test
    public void testDeleteOnRoot() {
        boolean delete = tree.delete(3);
        assertTrue("The root node should have been deleted", delete);
        assertEquals("Incorrect number of nodes", 2, TreeUtils.countAllNodes(tree.getRootNode()));
        assertNotNull("The root node should not be null", tree.getRootNode());
    }

    @Test
    public void testDeleteEntireTree() {
        assertEquals("Incorrect number of nodes in the tree.", 3, TreeUtils.countAllNodes(tree.getRootNode()));
        tree.deleteTree();
        assertNull("The root node should have been null", tree.getRootNode());
        assertEquals("Incorrect number of nodes in the tree", 0, TreeUtils.countAllNodes(tree.getRootNode()));
    }

    @Test
    public void testFindMin() {
        Node min = tree.findMin(tree.getRootNode());
        assertNotNull("The return value should not be null", min);
        assertEquals("Invalid minimum returned.", 2, min.getValue());
    }

    @Test
    public void testFindMinOnNullTree() {
        tree.deleteTree();
        Node min = tree.findMin(null);
        assertNull("Invalid minimum returned. The tree is empty and should have been null.", min);
    }

    @Test
    public void testFindMax() {
        Node max = tree.findMax(tree.getRootNode());
        assertNotNull("The return value should not be null", max);
        assertEquals("Invalid maximum returned", 4, max.getValue());
    }

    @Test
    public void testFindMaxOnNullTree() {
        tree.deleteTree();
        Node max = tree.findMax(tree.getRootNode());
        assertNull("Invalid maximum returned. The tree is empty and should have been null", max);
    }

    @Test
    public void testFindUnavailableValue() {
        Node node = tree.find(0);
        assertNull("The return value should have been null as this value is not available in the tree.", node);
    }

    @Test
    public void testFind() {
        Node node = tree.find(2);
        assertNotNull("The return value should not have been null.", node);
        assertNotNull("The node's parent should not be null.", node.getParent());
        assertEquals("Incorrect parent found.", 3, node.getParent().getValue());
        assertNull("The left child should be null", node.getLeftChild());
        assertNull("The right child should be null", node.getRightChild());
    }

    @Test
    public void testFindNextLargerOnRightSubTree() {
        tree.insert(Arrays.asList(5, 6));
        Node nextLarger = tree.findNextLarger(4);
        assertNotNull("The next larger node should not be null", nextLarger);
        assertEquals("Invalid next larger value", 5, nextLarger.getValue());
    }

    @Test
    public void testFindNextLarger_ThereIsNoNumberLargerThanThisNumber() {
        tree.insert(Arrays.asList(5, 6));
        Node nextLarger = tree.findNextLarger(6);
        assertNull("The next larger node should be null", nextLarger);
    }

    @Test
    public void testFindNextLargerOnLeftSubtree() {
        tree.deleteTree();
        List<Integer> integers = Lists.newArrayList(23, 8, 4, 16, 15, 42);
        tree.insert(integers);
        Node nextLarger = tree.findNextLarger(8);
        assertNotNull("Next larger should not be null", nextLarger);
        assertEquals("Next larger is invalid", 15, nextLarger.getValue());
        nextLarger = tree.findNextLarger(16);
        assertNotNull("Next larger should not be null", nextLarger);
        assertEquals("Next larger is invalid", 23, nextLarger.getValue());
    }

    @Test
    public void testFindNextLargerOnNullTree() {
        tree.deleteTree();
        Node nextLarger = tree.findNextLarger(1);
        assertNull("There is no tree. Should have been null", nextLarger);
    }

    @Test
    public void testFindNextSmaller_ThereIsNoNumberSmallerThanThisNumber() {
        tree.insert(Arrays.asList(5, 6));
        Node nextSmaller = tree.findNextSmaller(2);
        assertNull("There is no smaller value. Should be null.", nextSmaller);
    }

    @Test
    public void testFindNextSmaller() {
        tree.deleteTree();
        List<Integer> integers = Lists.newArrayList(23, 8, 4, 16, 15, 42);
        tree.insert(integers);
        Node nextSmaller = tree.findNextSmaller(42);
        assertNotNull("Next larger should not be null", nextSmaller);
        assertEquals("Next larger is invalid", 23, nextSmaller.getValue());
        tree.insert(39);
        nextSmaller = tree.findNextSmaller(39);
        assertNotNull("Next larger should not be null", nextSmaller);
        assertEquals("Next larger is invalid", 23, nextSmaller.getValue());
        nextSmaller = tree.findNextSmaller(8);
        assertNotNull("Next larger should not be null", nextSmaller);
        assertEquals("Next larger is invalid", 4, nextSmaller.getValue());
    }

    @Test
    public void testFindNextSmallerOnNullTree() {
        tree.deleteTree();
        Node nextSmaller = tree.findNextSmaller(1);
        assertNull("There is no tree. Should have been null", nextSmaller);
    }
}