package com.funkyganesha.sort;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.funkyganesha.sort.util.SorterUtil;
import com.google.common.base.Preconditions;

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
    private List<T> numbers;

    @Override
    public void sort(List<T> numbers) {
        Preconditions.checkArgument(CollectionUtils.isNotEmpty(numbers), "The input is either empty or null.");
        this.numbers = numbers;
        quickSort(0, numbers.size() - 1);
    }

    private void quickSort(int low, int high) {
        int mid = (low + high) / 2;
        T pivot = numbers.get(mid);
        int leftPointer = low;
        int rightPointer = high;
        while (leftPointer <= rightPointer) {
            while (numbers.get(leftPointer).compareTo(pivot) < 0) {
                leftPointer++;
            }
            while (numbers.get(rightPointer).compareTo(pivot) > 0) {
                rightPointer--;
            }
            if (leftPointer <= rightPointer) {
                SorterUtil.swap(numbers, leftPointer, rightPointer);
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
