package com.funkyganesha.tree;


import java.util.List;

import com.funkyganesha.tree.bean.Node;

public interface Tree {

    void insert(List<Integer> integers);

    void insert(int value);

    /**
     * @param value
     * @return true if node with value was deleted; false otherwise
     */
    boolean delete(int value);

    Node getRootNode();

    /**
     * Delete all the nodes in the tree.
     */
    void deleteTree();

    void deleteMin();

    void deleteMax();

    Node findMin(Node root);

    /**
     * The parameter passed need not be the root node. It can be a node at any level in the subtree.
     * @param node - node from where the max will be returned.
     * @return the node with maximum value
     */
    Node findMax(Node node);

    Node find(int value);

    /**
     * Given a value, find that node which has the next larger value in the tree.
     * @param value
     * @return
     */
    Node findNextLarger(int value);

    /**
     * Given a value, find that node which has the next smaller value in the tree.
     * @param value
     * @return
     */
    Node findNextSmaller(int value);
}
