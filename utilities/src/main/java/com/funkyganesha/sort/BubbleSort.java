package com.funkyganesha.sort;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.funkyganesha.sort.util.SorterUtil;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

/**
 * <ol>
 * <li>Stable</li>
 * <li>O(1) extra space</li>
 * <li>O(n*n) comparisons and swaps</li>
 * <li>Adaptive: O(n) when nearly sorted</li>
 * </ol>
 */
public class BubbleSort<T extends Comparable<? super T>> implements Sorter<T> {
    List<T> result;

    @Override
    public List<T> sort(List<T> values) {
        Preconditions.checkArgument(CollectionUtils.isNotEmpty(values), "The input is either null or empty.");
        result = Lists.newArrayList(values);
        boolean isSwapped = true;
        int j = 0;
        while (isSwapped) {
            isSwapped = false;
            j++;
            for (int i = 0; i < result.size() - j; i++) {
                if (result.get(i).compareTo(result.get(i + 1)) > 0) {
                    SorterUtil.swap(result, i, i + 1);
                    isSwapped = true;
                }
            }
        }
        return result;
    }

}
