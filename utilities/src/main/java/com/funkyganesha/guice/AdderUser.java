package com.funkyganesha.guice;

import java.util.List;

import com.google.inject.Inject;

public class AdderUser {
    @Inject
    private Adder adder;

    public void addNumbers(List<Integer> integers) {
        System.out.println("Input = " + integers);
        System.out.println("Sum of all the numbers = " + this.adder.add(integers));
    }
}
