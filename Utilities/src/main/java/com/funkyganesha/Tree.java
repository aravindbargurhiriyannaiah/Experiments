package com.funkyganesha;


import com.funkyganesha.bean.Node;

/**
 *
 */
public interface Tree {
    void printInOrder(Node root);

    void insert(int value);

    boolean delete(int value);

    boolean search(int value);

    Node getRootNode();

    int totalNumberOfNodes(Node root);

    int totalNumberOfLeafNodes(Node root);

}
