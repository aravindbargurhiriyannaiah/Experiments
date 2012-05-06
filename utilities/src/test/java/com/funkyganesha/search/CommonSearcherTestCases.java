package com.funkyganesha.search;


import java.util.List;

import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;

import com.funkyganesha.sort.MergeSort;
import com.funkyganesha.sort.Sorter;
import com.google.common.primitives.Ints;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public abstract class CommonSearcherTestCases {
    protected Searcher searcher;
    private int[] ints;

    @Test(expected = IllegalArgumentException.class)
    public void testSearchOnEmptyArray() {
        searcher.search(0, new int[]{});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSearchOnNullArray() {
        searcher.search(0, ints);
    }

    @Test
    public void testSearchOnValidArrayWithOneElementWhichIsTheKey() {
        ints = new int[]{3};
        boolean search = searcher.search(3, ints);
        assertTrue("The value should have been found.", search);
    }

    @Test
    public void testSearchOnValidArrayWithOneElementWhichIsNotTheKey() {
        ints = new int[]{3};
        boolean search = searcher.search(2, ints);
        assertFalse("The value should not have been found.", search);
    }

    @Test
    public void testSearchOnALargerArray() {
        ints = new int[RandomUtils.nextInt(100)];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = RandomUtils.nextInt(ints.length);
        }
        int element = ints[ints.length - 1];
        Sorter<Integer> sorter = new MergeSort<Integer>();
        List<Integer> values = Ints.asList(ints);
        values = sorter.sort(values);
        int[] sortedInts = Ints.toArray(values);
        boolean search = searcher.search(element, sortedInts);
        assertTrue("The value should have been found.", search);
    }
}
