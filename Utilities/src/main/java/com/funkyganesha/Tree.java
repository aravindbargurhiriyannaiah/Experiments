package com.funkyganesha;


import com.funkyganesha.bean.Node;

/**
 *
 */
public interface Tree {
    void traversePreOrder(Tree tree);

    void add(int value);

    void delete(Node node);

    Node search(int value);
}
