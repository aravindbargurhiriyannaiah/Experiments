package com.funkyganesha.sort;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.funkyganesha.sort.util.SorterUtil;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

/**
 * Properties
 * <ol><li>Not stable</li>
 * <li>O(1) extra space</li>
 * <li>Θ(n2) comparisons</li>
 * <li>Θ(n) swaps</li>
 * <li>Not adaptive</li></ol>
 */
public class SelectionSort<T extends Comparable<? super T>> implements Sorter<T> {
    private List<T> result;

    @Override
    public List<T> sort(List<T> values) {
        Preconditions.checkArgument(CollectionUtils.isNotEmpty(values), "The input is either null or empty.");
        this.result = Lists.newArrayList(values);
        int smallestNumbersIndex;
        for (int i = 0; i < this.result.size(); i++) {
            //find the smallest number's index and swap it with the current number.
            smallestNumbersIndex = findIndexOfSmallestNumber(i);
            SorterUtil.swap(this.result, i, smallestNumbersIndex);
        }
        return result;
    }

    private int findIndexOfSmallestNumber(int startIndex) {
        int minIndex = startIndex;
        for (int i = startIndex; i < result.size(); i++) {
            if (result.get(i).compareTo(result.get(minIndex)) < 0) {
                minIndex = i;
            }
        }
        return minIndex;
    }
}
