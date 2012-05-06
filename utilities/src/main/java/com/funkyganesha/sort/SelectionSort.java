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
public class SelectionSort<T extends Comparable<? super T>> implements Sorter<T> {
    private T[] values;

    @Override
    public void sort(T[] values) {
        Preconditions.checkArgument(ArrayUtils.isNotEmpty(values), "The input is either null or empty.");
        this.values = values;
        int smallestNumbersIndex;
        for (int i = 0; i < this.values.length; i++) {
            //find the smallest number's index and swap it with the current number.
            smallestNumbersIndex = findIndexOfSmallestNumber(i);
            SorterUtil.swap(this.values, i, smallestNumbersIndex);
        }
    }

    private int findIndexOfSmallestNumber(int startIndex) {
        int minIndex = startIndex;
        for (int i = startIndex; i < values.length; i++) {
            if (values[i].compareTo(values[minIndex]) < 0) {
                minIndex = i;
            }
        }
        return minIndex;
    }
}
