package com.funkyganesha.util;


import com.funkyganesha.bean.Node;

/**
 *
 */
public class TreeUtil {


    public static void printInOrder(Node t) {
        if (t != null) {
            printInOrder(t.getLeft());   // print nodes in left subtree
            System.out.println(t.getData());
            printInOrder(t.getRight());  // print nodes in right subtree
        }
    }
}
