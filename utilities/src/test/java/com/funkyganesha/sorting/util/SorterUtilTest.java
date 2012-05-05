package com.funkyganesha.sorting.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SorterUtilTest {
    private int[] integers;

    public static void compareAndAssertIfTheArrayIsSortedInAscendingOrder(int[] ints) {
        for (int i = 0; i < ints.length - 1; i++) {
            if (ints[i] > ints[i + 1]) {
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
        integers = new int[]{};
        SorterUtil.swap(integers, 0, 0);
    }

    @Test
    public void testSwap() {
        integers = new int[]{3, 1, 2};
        SorterUtil.swap(integers, 2, 0);
        assertEquals("Invalid number because it is incorrectly swapped.", 2, integers[0]);
        assertEquals("Invalid number because it is incorrectly swapped.", 3, integers[2]);
    }
}
