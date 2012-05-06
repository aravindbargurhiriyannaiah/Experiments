package com.funkyganesha.sort;

import org.junit.Before;

public class BubbleSortSorterTest extends CommonSorterTestCases {
    @Before
    public void setUp() {
        integerSorter = new BubbleSort<Integer>();
        stringSorter = new BubbleSort<String>();
        doubleSorter = new BubbleSort<Double>();
    }
}
