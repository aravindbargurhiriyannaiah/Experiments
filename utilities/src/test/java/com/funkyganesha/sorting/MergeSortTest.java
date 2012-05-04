package com.funkyganesha.sorting;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;

/**
 *
 */
public class MergeSortTest {
    private Sorter sorter;

    @Before
    public void setUp() throws Exception {
        sorter = new MergeSort();
    }

    @Test
    public void testSortArrayWithValidListOfEvenNumberOfElements() {
        int[] ints = Ints.toArray(Lists.newArrayList(5, 0, -4, -19));
        sorter.sort(ints);
        SorterTestUtils.compareAndAssertIfTheArrayIsSortedInAscendingOrder(ints);
    }

    @Test
    public void testSortArrayWithValidListOfOddNumberOfElements() {
        int[] ints = Ints.toArray(Lists.newArrayList(3, 24, 15, -1, -19));
        sorter.sort(ints);
        SorterTestUtils.compareAndAssertIfTheArrayIsSortedInAscendingOrder(ints);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSortWithEmptyArray() throws Exception {
        int[] unsortedNumber = new int[]{};
        sorter.sort(unsortedNumber);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSortWithNullArray() throws Exception {
        int[] unsortedNumber = null;
        sorter.sort(unsortedNumber);
    }
}
