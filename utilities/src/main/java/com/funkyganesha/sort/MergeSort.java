package com.funkyganesha.sort;

import org.apache.commons.lang.ArrayUtils;

import com.google.common.base.Preconditions;

/**
 * Some useful information about merge sort (http://www.sorting-algorithms.com/merge-sort)
 * <ol>
 * <li>Stable</li>
 * <li>O(n) extra space for linked lists</li>
 * <li>O(n log (n)) time</li>
 * <li>Not adaptive</li>
 * <li>Does not require random access to data</li>
 * </ol>
 */
public class MergeSort implements Sorter {
    private int[] numbers;
    private int[] tempArray;

    @Override
    public void sort(int[] numbers) {
        Preconditions.checkArgument(ArrayUtils.isNotEmpty(numbers), "The input is null or empty");
        this.numbers = numbers;
        tempArray = new int[numbers.length];
        divideArray(0, numbers.length - 1);
    }

    private void divideArray(int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            divideArray(low, mid);
            divideArray(mid + 1, high);
            mergeArrays(low, mid, high);
        }
    }

    private void mergeArrays(int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            tempArray[i] = numbers[i];
        }
        int i = low;
        int k = low;
        int j = mid + 1;
        while (i <= mid && j <= high) {
            numbers[k++] = (tempArray[i] <= tempArray[j]) ? tempArray[i++] : tempArray[j++];
        }
        while (i <= mid) {
            numbers[k++] = tempArray[i++];
        }
    }
}
