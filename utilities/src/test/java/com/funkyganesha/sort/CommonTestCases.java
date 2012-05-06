package com.funkyganesha.sort;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;

import com.funkyganesha.sort.util.SorterUtilTest;

public abstract class CommonTestCases {
    protected Sorter sorter;
    private Integer[] ints;

    @Test
    public void testWithSortedArray() {
        ints = new Integer[]{-9, 10, 15, 98, 113};
        sorter.sort(ints);
        SorterUtilTest.compareAndAssertIfTheArrayIsSortedInAscendingOrder(ints);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testWithNullArray() {
        sorter.sort(ints);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testWithEmptyArray() {
        ints = new Integer[] {};
        sorter.sort(ints);
    }

    @Test
    public void testSortWithOnlyOneValue() {
        ints = new Integer[]{4};
        sorter.sort(ints);
    }

    @Test
    public void testWithValidArray_1() {
        ints = new Integer[21];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = RandomUtils.nextInt(100);
        }
        sorter.sort(ints);
        SorterUtilTest.compareAndAssertIfTheArrayIsSortedInAscendingOrder(ints);
    }

    @Test
    public void testWithValidArray_2() {
        ints = new Integer[10];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = RandomUtils.nextInt(100);
        }
        sorter.sort(ints);
        SorterUtilTest.compareAndAssertIfTheArrayIsSortedInAscendingOrder(ints);
    }

    @Test
    public void testWithLargeArray() {
        ints = new Integer[RandomUtils.nextInt(200)];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = RandomUtils.nextInt(100);
        }
        sorter.sort(ints);
        SorterUtilTest.compareAndAssertIfTheArrayIsSortedInAscendingOrder(ints);
    }

    @Test
    public void testWithStrings() {
        String[] strings = new String[RandomUtils.nextInt(100)];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = RandomStringUtils.randomAlphanumeric(100);
        }
        sorter.sort(strings);
        SorterUtilTest.compareAndAssertIfTheArrayIsSortedInAscendingOrder(strings);
    }

    @Test
    public void testWithDouble() {
        Double[] doubles = new Double[RandomUtils.nextInt(10)];
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = RandomUtils.nextDouble();
        }
        sorter.sort(doubles);
        SorterUtilTest.compareAndAssertIfTheArrayIsSortedInAscendingOrder(doubles);
        


    }
}
