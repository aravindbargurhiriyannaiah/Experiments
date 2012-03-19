package com.funkyganesha;


import com.funkyganesha.bean.Node;

/**
 *
 */
public interface Tree {
    void traversePreOrder(Tree tree);

    void insert(int value);

    void delete(int value);

    boolean search(int value);
}
