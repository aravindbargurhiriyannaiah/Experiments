package com.funkyganesha.guice;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.google.common.base.Preconditions;

/**
 *
 */
public class DumbAdder implements Adder {
    @Override
    public int add(List<Integer> integers) {
        System.out.println("Using dumb adder.");
        Preconditions.checkArgument(CollectionUtils.isNotEmpty(integers), "The list of integers cannot be null or empty");
        int sum = 0;
        for (Integer integer : integers) {
            sum = sum + integer;
        }
        return sum;
    }
}
