package com.funkyganesha.sorting;

import org.junit.Before;
import org.junit.Test;

public class SelectionSortTest {
    private Sorter sorter;
    private int[] ints;

    @Before
    public void setUp() throws Exception {
        sorter = new SelectionSort();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSortWithNull() {
        sorter.sort(ints);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSortWithEmpty() {
        sorter.sort(new int[]{});
    }

    @Test
    public void testSort() {
        ints = new int[]{5, 4, 3, 90, 1};
        sorter.sort(ints);
        SorterTestUtils.compareAndAssertIfTheArrayIsSortedInAscendingOrder(ints);
    }

    @Test
    public void testSortWithOnlyOneValue() {
        ints = new int[]{4};
        sorter.sort(ints);
    }
}
