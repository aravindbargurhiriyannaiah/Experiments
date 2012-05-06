package com.funkyganesha.sort.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SorterUtilTest {
    private Integer[] integers;

    public static<T extends Comparable<? super T>> void compareAndAssertIfTheArrayIsSortedInAscendingOrder(T[] ints) {
        for (int i = 0; i < ints.length - 1; i++) {
            if (ints[i].compareTo(ints[i+1]) > 0) {
                fail("Invalid value at index [" + i + "]");
            }
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSwapWithNullArray() {
        SorterUtil.swap(integers, 0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSwapWithEmptyArray() {
        integers = new Integer[]{};
        SorterUtil.swap(integers, 0, 0);
    }

    @Test
    public void testSwap() {
        integers = new Integer[]{3, 1, 2};
        SorterUtil.swap(integers, 2, 0);
        assertEquals("Invalid number because it is incorrectly swapped.", new Integer(2), integers[0]);
        assertEquals("Invalid number because it is incorrectly swapped.", new Integer(3), integers[2]);
    }
}
