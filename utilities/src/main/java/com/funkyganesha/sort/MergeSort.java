package com.funkyganesha.sort;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

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
public class MergeSort<T extends Comparable<? super T>> implements Sorter<T> {
    private List<T> values;

    @Override
    public void sort(List<T> values) {
        Preconditions.checkArgument(CollectionUtils.isNotEmpty(values), "The input is null or empty");
        this.values = values;
        divideArray(0, values.size() - 1);
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
        int i = low;
        int k = low;
        int j = mid + 1;
        while (i <= mid && j <= high) {
            T element1 = values.get(i);
            T element2 = values.get(j);
            T t;
            if (element1.compareTo(element2) <= 0) {
                t = element1;
                i++;
            } else {
                t = element2;
                j++;
            }
            values.set(k++, t);
        }
        while (i <= mid) {
            values.set(k++, values.get(i++));
        }
    }
}
