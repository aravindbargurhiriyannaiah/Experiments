package com.funkyganesha.sort;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.funkyganesha.sort.util.SorterUtil;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

/**
 * Properties
 * <ol>
 * <li>Not stable</li>
 * <li>O(lg(n)) extra space (see discussion)</li>
 * <li>O(n2) time, but typically O(n·lg(n)) time</li>
 * <li>Not adaptive</li>
 * </ol>
 */
public class QuickSort<T extends Comparable<? super T>> implements Sorter<T> {
    private List<T> result;

    @Override
    public List<T> sort(List<T> values) {
        Preconditions.checkArgument(CollectionUtils.isNotEmpty(values), "The input is either empty or null.");
        this.result = Lists.newArrayList(values);
        quickSort(0, result.size() - 1);
        return result;
    }

    private void quickSort(int low, int high) {
        int mid = (low + high) / 2;
        T pivot = result.get(mid);
        int leftPointer = low;
        int rightPointer = high;
        while (leftPointer <= rightPointer) {
            while (result.get(leftPointer).compareTo(pivot) < 0) {
                leftPointer++;
            }
            while (result.get(rightPointer).compareTo(pivot) > 0) {
                rightPointer--;
            }
            if (leftPointer <= rightPointer) {
                SorterUtil.swap(result, leftPointer, rightPointer);
                leftPointer++;
                rightPointer--;
            }
        }
        if (low < rightPointer) {
            quickSort(low, rightPointer);
        }
        if (leftPointer < high) {
            quickSort(leftPointer, high);
        }
    }
}
