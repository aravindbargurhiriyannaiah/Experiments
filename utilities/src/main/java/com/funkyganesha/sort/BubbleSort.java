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
public class BubbleSort<T extends Comparable<? super T>> implements Sorter<T> {
    @Override
    public void sort(T[] values) {
        Preconditions.checkArgument(ArrayUtils.isNotEmpty(values), "The input is either null or empty.");
        boolean isSwapped = true;
        int j = 0;
        while (isSwapped) {
            isSwapped = false;
            j++;
            for (int i = 0; i < values.length - j; i++) {
                if ((values[i].compareTo(values[i + 1])) > 0) {
                    SorterUtil.swap(values, i, i + 1);
                    isSwapped = true;
                }
            }
        }
    }
}
