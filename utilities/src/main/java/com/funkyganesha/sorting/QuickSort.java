package com.funkyganesha.sorting;

import org.apache.commons.lang.ArrayUtils;

import com.funkyganesha.sorting.util.SorterUtil;
import com.google.common.base.Preconditions;

/**
 * Properties
 * <ol>
 *  <li>Not stable</li>
 * <li>O(lg(n)) extra space (see discussion)</li>
 * <li>O(n2) time, but typically O(n·lg(n)) time</li>
 * <li>Not adaptive</li>
 * </ol>
 */
public class QuickSort implements Sorter {
    private int[] numbers;

    @Override
    public void sort(int[] numbers) {
        Preconditions.checkArgument(ArrayUtils.isNotEmpty(numbers), "The input is either empty or null.");
        this.numbers = numbers;
        quickSort(0, numbers.length - 1);
    }

    private void quickSort(int low, int high) {
        int pivot = numbers[(low + high) / 2];
        int leftPointer = low;
        int rightPointer = high;
        while (leftPointer <= rightPointer) {
            while (numbers[leftPointer] < pivot) {
                leftPointer++;
            }
            while (numbers[rightPointer] > pivot) {
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
