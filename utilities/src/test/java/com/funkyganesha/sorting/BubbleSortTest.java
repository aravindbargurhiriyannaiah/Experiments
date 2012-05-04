package com.funkyganesha.sorting;

import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class BubbleSortTest {
    private Sorter sorter;
    private int[] ints;

    @Before
    public void setUp() throws Exception {
        sorter = new BubbleSort();
    }

    @Test
    public void testSortWithValidArray() {
        ints = new int[]{9, -1, 5, -98, 3};
        sorter.sort(ints);
        SorterTestUtils.compareAndAssertIfTheArrayIsSortedInAscendingOrder(ints);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSortWithEmtpyValue() throws Exception {
        ints = null;
        sorter.sort(ints);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testSortWithNullValue() throws Exception {
        sorter.sort(ints);
    }
}
