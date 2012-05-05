package com.funkyganesha.sort;

import org.apache.commons.lang.ArrayUtils;

import com.funkyganesha.sort.util.SorterUtil;
import com.google.common.base.Preconditions;

/**
 * Properties
 * <ol><li>Not stable</li>
 * <li>O(1) extra space</li>
 * <li>Θ(n2) comparisons</li>
 * <li>Θ(n) swaps</li>
 * <li>Not adaptive</li></ol>
 */
public class SelectionSort implements Sorter {
    private int[] numbers;

    @Override
    public void sort(int[] numbers) {
        Preconditions.checkArgument(ArrayUtils.isNotEmpty(numbers), "The input is either null or empty.");
        this.numbers = numbers;
        for (int i = 0; i < this.numbers.length; i++) {
            //find the smallest number's index and swap it with the current number.
            int smallestNumbersIndex = findSmallestNumbersIndex(i);
            SorterUtil.swap(this.numbers, i, smallestNumbersIndex);
        }
    }

    private int findSmallestNumbersIndex(int startIndex) {
        int minIndex = startIndex;
        for (int i = startIndex; i < numbers.length; i++) {
            if (numbers[i] < numbers[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }
}
