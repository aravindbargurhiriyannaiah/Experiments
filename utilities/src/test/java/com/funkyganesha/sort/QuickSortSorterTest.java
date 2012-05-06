package com.funkyganesha.sort;

import org.junit.Before;

public class QuickSortSorterTest extends CommonSorterTestCases {

    @Before
    public void setUp() throws Exception {
        integerSorter = new QuickSort<Integer>();
        doubleSorter = new QuickSort<Double>();
        stringSorter = new QuickSort<String>();

    }
}
