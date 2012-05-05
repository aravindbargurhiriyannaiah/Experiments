package com.funkyganesha.sort;

import org.apache.commons.lang.ArrayUtils;

import com.funkyganesha.sort.util.SorterUtil;
import com.google.common.base.Preconditions;

/**
 * <ol>
 * <li>Stable</li>
 * <li>O(1) extra space</li>
 * <li>O(n*n) comparisons and swaps</li>
 * <li>Adaptive: O(n) when nearly sorted</li>
 * </ol>
 */
public class BubbleSort implements Sorter {

    @Override
    public void sort(int[] numbers) {
        Preconditions.checkArgument(ArrayUtils.isNotEmpty(numbers), "The input is either null or empty.");
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
