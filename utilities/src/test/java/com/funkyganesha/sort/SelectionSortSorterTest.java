package com.funkyganesha.sort;

import org.junit.Before;

public class SelectionSortSorterTest extends CommonSorterTestCases {

    @Before
    public void setUp() throws Exception {
        integerSorter = new SelectionSort<Integer>();
        doubleSorter = new SelectionSort<Double>();
        stringSorter = new SelectionSort<String>();
    }
}
