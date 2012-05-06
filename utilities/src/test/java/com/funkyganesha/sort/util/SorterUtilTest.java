package com.funkyganesha.sort.util;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

import static org.junit.Assert.assertEquals;

public class SorterUtilTest<T> {
    private List<T> list;

    public static <T extends Comparable<? super T>> void compareAndAssertIfTheElementsAreSortedInAscendingOrder(List<T> input, List output) {
        assertEquals("Incorrect number of elements in the output.", input.size(), output.size());
        Collections.sort(input);
        for (int i = 0; i < input.size(); i++) {
            assertEquals("Invalid element at index.", input.get(i), output.get(i));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSwapWithNullList() {
        SorterUtil.swap(list, 0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSwapWithEmptyList() {
        list = Lists.newArrayList();
        SorterUtil.swap(list, 0, 0);
    }

    @Test
    public void testSwapOnList() {
        List<Integer> list = Lists.newArrayList(3, 1, 2);
        SorterUtil.swap(list, 2, 0);
        assertEquals("Invalid number because it is incorrectly swapped.", new Integer(2), list.get(0));
        assertEquals("Invalid number because it is incorrectly swapped.", new Integer(3), list.get(2));
    }
}
