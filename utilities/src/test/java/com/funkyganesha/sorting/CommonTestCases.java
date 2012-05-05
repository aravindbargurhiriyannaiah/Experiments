package com.funkyganesha.sorting;

import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;

import com.funkyganesha.sorting.util.SorterUtilTest;

public abstract class CommonTestCases {
    protected Sorter sorter;
    private int[] ints;

    @Test
    public void testWithSortedArray() {
        ints = new int[]{-9, 10, 15, 98, 113};
        sorter.sort(ints);
        SorterUtilTest.compareAndAssertIfTheArrayIsSortedInAscendingOrder(ints);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testWithNullArray() {
        sorter.sort(ints);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testWithEmptyArray() {
        ints = new int[] {};
        sorter.sort(ints);
    }

    @Test
    public void testSortWithOnlyOneValue() {
        ints = new int[]{4};
        sorter.sort(ints);
    }

    @Test
    public void testWithValidArray_1() {
        ints = new int[21];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = RandomUtils.nextInt(100);
        }
        sorter.sort(ints);
        SorterUtilTest.compareAndAssertIfTheArrayIsSortedInAscendingOrder(ints);
    }

    @Test
    public void testWithValidArray_2() {
        ints = new int[10];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = RandomUtils.nextInt(100);
        }
        sorter.sort(ints);
        SorterUtilTest.compareAndAssertIfTheArrayIsSortedInAscendingOrder(ints);
    }

    @Test
    public void testWithLargeArray() {
        ints = new int[RandomUtils.nextInt(200)];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = RandomUtils.nextInt(100);
        }
        sorter.sort(ints);
        SorterUtilTest.compareAndAssertIfTheArrayIsSortedInAscendingOrder(ints);
    }
}
