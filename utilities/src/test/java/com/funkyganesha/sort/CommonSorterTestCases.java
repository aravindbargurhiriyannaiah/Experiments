package com.funkyganesha.sort;

import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;

import com.funkyganesha.sort.util.SorterUtilTest;
import com.google.common.collect.Lists;

public abstract class CommonSorterTestCases {
    protected Sorter sorter;
    private List<Integer> list;

    @Test
    public void testWithSortedArray() {
        list = Lists.newArrayList(-9, 10, 15, 98, 113);
        sorter.sort(list);
        SorterUtilTest.compareAndAssertIfTheArrayIsSortedInAscendingOrder(list);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNullArray() {
        sorter.sort(list);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithEmptyArray() {
        list = Lists.newArrayList();
        sorter.sort(list);
    }

    @Test
    public void testSortWithOnlyOneValue() {
        list = Lists.newArrayList(4);
        sorter.sort(list);
    }

    @Test
    public void testWithLargeArray() {
        list = Lists.newLinkedList();
        for (int i = 0; i < 200; i++) {
            list.add(RandomUtils.nextInt(100));
        }
        sorter.sort(list);
        SorterUtilTest.compareAndAssertIfTheArrayIsSortedInAscendingOrder(list);
    }

    @Test
    public void testWithStrings() {
        List<String> strings = Lists.newLinkedList();
        for (int i = 0; i < RandomUtils.nextInt(100); i++) {
            strings.add(RandomStringUtils.randomAlphanumeric(100));
        }
        sorter.sort(strings);
        SorterUtilTest.compareAndAssertIfTheArrayIsSortedInAscendingOrder(strings);
    }

    @Test
    public void testWithDouble() {
        List<Double> doubles = Lists.newLinkedList();
        for (int i = 0; i < RandomUtils.nextInt(100); i++) {
            doubles.add(RandomUtils.nextDouble());
        }
        sorter.sort(doubles);
        SorterUtilTest.compareAndAssertIfTheArrayIsSortedInAscendingOrder(doubles);
    }
}
