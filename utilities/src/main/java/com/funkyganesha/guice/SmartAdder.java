package com.funkyganesha.guice;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.google.common.base.Preconditions;

/**
 *
 */
public class SmartAdder implements Adder {

    @Override
    public int add(List<Integer> integers) {
        System.out.println("Using Smart Adder");
        Preconditions.checkArgument(CollectionUtils.isNotEmpty(integers), "The list of integers cannot be null or empty");
        int lastInteger = integers.get(integers.size() - 1);
        return (lastInteger * (lastInteger + 1))/2;
    }
}
