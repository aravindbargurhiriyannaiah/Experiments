package com.funkyganesha.sort;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

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
    public void sort(List<T> values) {
        Preconditions.checkArgument(CollectionUtils.isNotEmpty(values), "The input is either null or empty.");
        boolean isSwapped = true;
        int j = 0;
        while (isSwapped) {
            isSwapped = false;
            j++;
            for (int i = 0; i < values.size() - j; i++) {
                if (values.get(i).compareTo(values.get(i + 1)) > 0) {
                    SorterUtil.swap(values, i, i + 1);
                    isSwapped = true;
                }
            }
        }
    }
}
