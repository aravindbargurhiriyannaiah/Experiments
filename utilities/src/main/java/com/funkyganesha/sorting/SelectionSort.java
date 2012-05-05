package com.funkyganesha.sorting;

import org.apache.commons.lang.ArrayUtils;

import com.funkyganesha.sorting.util.SorterUtil;
import com.google.common.base.Preconditions;

public class SelectionSort implements Sorter {
    private int[] numbers;

    @Override
    public void sort(int[] numbers) {
        Preconditions.checkArgument(ArrayUtils.isNotEmpty(numbers), "The input is either null or empty");
        this.numbers = numbers;
        int minIndex;
        for (int i = 0; i < numbers.length; i++) {
            minIndex = findIndexOfSmallestElement(i);
            SorterUtil.swap(numbers, minIndex, i);
        }
    }

    private int findIndexOfSmallestElement(int startIndex) {
        int minIndex = startIndex;
        for (int i = startIndex; i < numbers.length; i++) {
            minIndex = (numbers[i] < numbers[minIndex]) ? i : minIndex;
        }
        return minIndex;
    }
}
