package com.funkyganesha.sort;

import org.junit.Before;

public class MergeSortSorterTest extends CommonSorterTestCases {

    @Before
    public void setUp() throws Exception {
        integerSorter = new MergeSort<Integer>();
        doubleSorter = new MergeSort<Double>();
        stringSorter = new MergeSort<String>();
    }
}
