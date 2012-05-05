package com.funkyganesha.sorting;

import org.apache.commons.lang.ArrayUtils;

import com.funkyganesha.sorting.util.SorterUtil;
import com.google.common.base.Preconditions;

public class BubbleSort implements Sorter {

    @Override
    public void sort(int[] numbers) {
        Preconditions.checkArgument(ArrayUtils.isNotEmpty(numbers), "The input is either null or empty");
        boolean isSwapped = true;
        int j = 0;
        while (isSwapped) {
            isSwapped = false;
            j++;
            for (int i = 0; i < numbers.length - j; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    SorterUtil.swap(numbers, i, i + 1);
                    isSwapped = true;
                }
            }
        }
    }
}
