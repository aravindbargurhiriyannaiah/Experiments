package com.funkyganesha.tree;


import com.funkyganesha.tree.bean.Node;

public interface Tree {

    void insert(int value);

    /**
     * @param value
     * @return true if node with value was deleted; false otherwise
     */
    boolean delete(int value);

    boolean search(int value);

    Node getRootNode();

    /**
     * Delete all the nodes in the tree.
     */
    void deleteTree();

    void deleteMin();

    void deleteMax();

    int findMin();

    int findMax();


}
