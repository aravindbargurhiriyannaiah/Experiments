package com.funkyganesha;


import com.funkyganesha.bean.Node;

/**
 *
 */
public interface Tree {
    /**
     * Search within the tree.
     *
     * @param data
     * @return true if data is available in the tree, false otherwise.
     */
    boolean search(int data);


    /**
     * insert into the tree.
     *
     *
     *
     *
     *
     *
     * @param data
     * @return
     */
    void insert(int data);

    void remove(Node node);

    Node getRoot();
}
