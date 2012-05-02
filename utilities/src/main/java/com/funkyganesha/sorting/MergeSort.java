package com.funkyganesha.sorting;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;

import com.google.common.primitives.Ints;

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
    private int[] result;
    private int[] tempArray;

    @Override
    public List<Integer> sort(List<Integer> unsortedIntegers) {
        List<Integer> sortedNumbers = null;
        if (CollectionUtils.isNotEmpty(unsortedIntegers)) {
            tempArray = new int[unsortedIntegers.size()];
            int[] sortedSet = sort(Ints.toArray(unsortedIntegers));
            sortedNumbers = Ints.asList(sortedSet);
        }
        return sortedNumbers;
    }

    @Override
    public int[] sort(int[] unsortedIntegers) {
        if (ArrayUtils.isNotEmpty(unsortedIntegers)) {
            result = unsortedIntegers;
            mergeSort(0, result.length - 1);
        }
        return result;
    }

    private void mergeSort(int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(low, mid);
            mergeSort(mid + 1, high);
            simpleMerge(low, mid, high);
        }
    }

    private void simpleMerge(int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            tempArray[i] = result[i];
        }
        int i = low;
        int k = low;
        int j = mid + 1;
        // ensure that the indexes are not out of bounds - this is like two piles of sorted cards.
        // Pick the right one and place it upside down. Move on till one pile is done. Copy the remaining cards in the other pile as is
        while (i <= mid && j <= high) {
            result[k++] = (tempArray[i] <= tempArray[j]) ? tempArray[i++] : tempArray[j++];
        }

        while (i <= mid) {
            result[k++] = tempArray[i++];
        }
    }
}
