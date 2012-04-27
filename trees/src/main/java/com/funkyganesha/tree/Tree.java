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

    /**
     * Find the min in the tree from the root.
     *
     * @return
     */
    Node findMin();

    Node findMax();

    /**
     * At worst case the traversal goes the longest branch. The worst case complexity would be O(h) where h is  the height of the tree.
     *
     * @param node
     * @return
     */
    Node findMin(Node node);

    /**
     * The parameter passed need not be the root node. It can be a node at any level in the sub-tree. At worst case the traversal goes the longest branch.
     * The worst case complexity would be O(h) where h is  the height of the tree.
     *
     * @param node - node from where the max will be returned.
     * @return the node with maximum value
     */
    Node findMax(Node node);

    Node find(int value);

    /**
     * Given a value, find that node which has the next larger value in the tree.
     *
     * @param value
     * @return
     */
    Node findNextLarger(int value);

    /**
     * Given a value, find that node which has the next smaller value in the tree.
     *
     * @param value
     * @return
     */
    Node findNextSmaller(int value);

    /**
     * Delete the node with largest value in the sub-tree from the provided argument
     *
     * @param node
     * @return true if deleted, false otherwise
     */
    boolean deleteMax(Node node);

    /**
     * Delete the node with smallest value in the sub-tree from the provided argument
     *
     * @param node
     * @return true if deleted, false otherwise
     */
    boolean deleteMin(Node node);

    /**
     * Delete the node with smallest value in the tree.
     *
     * @return true if deleted, false otherwise
     */
    boolean deleteMin();

    /**
     * Delete the node with largest value in the tree.
     *
     * @return true if deleted, false otherwise
     */
    boolean deleteMax();

    void deleteDuplicateNodes();
}
