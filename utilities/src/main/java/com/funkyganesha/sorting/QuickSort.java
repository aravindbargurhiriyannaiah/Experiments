package com.funkyganesha.sorting;

import org.apache.commons.lang.ArrayUtils;

import com.funkyganesha.sorting.util.SorterUtil;
import com.google.common.base.Preconditions;

/**
 *
 */
public class QuickSort implements Sorter {
    private int[] ints;

    @Override
    public void sort(int[] numbers) {
        Preconditions.checkArgument(ArrayUtils.isNotEmpty(numbers), "The input is either empty or null.");
        this.ints = numbers;
        quickSort(0, numbers.length - 1);
    }

    private void quickSort(int low, int high) {
        int pivot = ints[(low + high) / 2];
        int left = low;
        int right = high;
        while (left <= right) {
            while (ints[left] < pivot) {
                left++;
            }
            while (ints[right] > pivot) {
                right--;
            }
            if (left <= right) {
                SorterUtil.swap(ints, left, right);
                left++;
                right--;
            }
        }
        if (low < right) {
            quickSort(low, right);
        }
        if (left < high) {
            quickSort(left, high);
        }
    }
}
