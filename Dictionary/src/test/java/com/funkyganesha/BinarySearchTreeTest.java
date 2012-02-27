package com.funkyganesha;

import org.apache.commons.lang.math.RandomUtils;
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
        for (int i = 0 ; i < 1000 ; i++) {
            tree.insert(RandomUtils.nextInt());
        }
        TreeUtil.printInOrder(tree.getRoot());

    }
}
