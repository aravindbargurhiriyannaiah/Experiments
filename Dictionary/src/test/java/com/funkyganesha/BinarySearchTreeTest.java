package com.funkyganesha;

import org.junit.Before;
import org.junit.Test;

import com.funkyganesha.util.TreeUtil;

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
    public void testInsert() throws Exception {
        tree.insert(3);
        tree.insert(1);
        tree.insert(2);
        TreeUtil.printInOrder(tree.getRoot());

    }
}
