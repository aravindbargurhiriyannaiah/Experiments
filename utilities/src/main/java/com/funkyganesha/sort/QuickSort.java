package com.funkyganesha.sort;

import org.apache.commons.lang.ArrayUtils;

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
    private T[] numbers;

    @Override
    public void sort(T[] numbers) {
        Preconditions.checkArgument(ArrayUtils.isNotEmpty(numbers), "The input is either empty or null.");
        this.numbers = numbers;
        quickSort(0, numbers.length - 1);
    }

    private void quickSort(int low, int high) {
        T pivot = numbers[(low + high) / 2];
        int leftPointer = low;
        int rightPointer = high;
        while (leftPointer <= rightPointer) {
            while (numbers[leftPointer].compareTo(pivot) < 0) {
                leftPointer++;
            }
            while (numbers[rightPointer].compareTo(pivot) > 0) {
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
