package com.funkyganesha.sort;

import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;

import com.funkyganesha.sort.util.SorterUtilTest;
import com.google.common.collect.Lists;

public abstract class CommonSorterTestCases {
    protected Sorter<Integer> integerSorter;
    protected Sorter<String> stringSorter;
    protected Sorter<Double> doubleSorter;
    private List<Integer> list;

    @Test
    public void testWithSortedArray() {
        list = Lists.newArrayList(-9, 10, 15, 98, 113);
        List sort = integerSorter.sort(list);
        SorterUtilTest.compareAndAssertIfTheElementsAreSortedInAscendingOrder(list, sort);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNullArray() {
        integerSorter.sort(list);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithEmptyArray() {
        list = Lists.newArrayList();
        integerSorter.sort(list);
    }

    @Test
    public void testSortWithOnlyOneValue() {
        list = Lists.newArrayList(4);
        integerSorter.sort(list);
    }

    @Test
    public void testWithLargeArray() {
        list = Lists.newLinkedList();
        for (int i = 0; i < 50; i++) {
            list.add(RandomUtils.nextInt(100));
        }
        List sort = integerSorter.sort(list);
        SorterUtilTest.compareAndAssertIfTheElementsAreSortedInAscendingOrder(list, sort);
    }

    @Test
    public void testWithStrings() {
        List<String> strings = Lists.newLinkedList();
        for (int i = 0; i < RandomUtils.nextInt(100); i++) {
            strings.add(RandomStringUtils.randomAlphanumeric(100));
        }
        List<String> sortedStrings = stringSorter.sort(strings);
        SorterUtilTest.compareAndAssertIfTheElementsAreSortedInAscendingOrder(strings, sortedStrings);
    }

    @Test
    public void testWithDouble() {
        List<Double> doubles = Lists.newLinkedList();
        for (int i = 0; i < RandomUtils.nextInt(100); i++) {
            doubles.add(RandomUtils.nextDouble());
        }
        List<Double> sortedDoubles = doubleSorter.sort(doubles);
        SorterUtilTest.compareAndAssertIfTheElementsAreSortedInAscendingOrder(doubles, sortedDoubles);
    }
}
