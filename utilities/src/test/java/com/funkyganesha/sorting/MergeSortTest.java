package com.funkyganesha.sorting;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

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
    public void testSortListWithValidListOfEvenNumberOfElements() {
        List<Integer> list = Lists.newArrayList(3, 2, 5, 1, -9, 1);
        List<Integer> sort = sorter.sort(list);
        compareAndAssertLists(list, sort);
    }

    @Test
    public void testSortListWithValidListOfOddNumberOfElements() {
        List<Integer> list = Lists.newArrayList(3, 2, 5, 1, -9);
        List<Integer> sort = sorter.sort(list);
        compareAndAssertLists(list, sort);
    }

    @Test
    public void testSortListWithValidListOfOneElement() {
        List<Integer> list = Lists.newArrayList(2);
        List<Integer> sort = sorter.sort(list);
        assertNotNull("Sorted list should not be null", sort);
        assertEquals("Incorrect size of the sorted list", list.size(), sort.size());
    }

    @Test
    public void testSortListWithValidArrayOfOneElement() {
        int[] ints = new int[]{4};
        int[] sort = sorter.sort(ints);
        assertNotNull("Sorted list should not be null", sort);
        assertEquals("Incorrect size of the sorted list", ints.length, sort.length);
    }

    @Test
    public void testSortListWithEmptyList() throws Exception {
        List<Integer> integers = Lists.newArrayList();
        List<Integer> sort = sorter.sort(integers);
        assertNull("Sorted list should be null", sort);
    }

    private void compareAndAssertLists(List<Integer> expected, List<Integer> actual) {
        assertNotNull("The result should not be null", actual);
        assertEquals("Incorrect number of elements in the result", expected.size(), actual.size());
        Collections.sort(expected);
        int count = 0;
        for (Integer i : expected) {
            assertEquals("Incorrect value", i, actual.get(count++));
        }
    }

    @Test
    public void testSortWithEmptyArray() throws Exception {
        int[] unsortedNumber = new int[]{};
        int[] sort = sorter.sort(unsortedNumber);
        assertNull("Sorted array should be null.", sort);

    }
}
