package com.funkyganesha;


import com.funkyganesha.bean.Node;

/**
 *
 */
public interface Tree {

    boolean search(int data);

    void insert(int data);

    void remove(Node node);

    Node getRoot();
}
