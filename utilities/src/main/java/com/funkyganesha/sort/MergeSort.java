package com.funkyganesha.sort;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

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
    @Override
    public List<T> sort(List<T> values) {
        Preconditions.checkArgument(CollectionUtils.isNotEmpty(values), "The input is null or empty");
        return mergeSort(values);
    }

    protected List<T> mergeSort(List<T> integers) {
        if (integers.size() < 2) {
            //it is already sorted
            return integers;
        }
        List<T> left = Lists.newArrayList();
        List<T> right = Lists.newArrayList();
        List<T> sortedLeft;
        List<T> sortedRight;
        List<T> sorted;

        T integer;
        for (int i = 0; i < integers.size(); i++) {
            integer = integers.get(i);
            if (i < (integers.size() / 2)) {
                left.add(integer);
            } else {
                right.add(integer);
            }
        }
        sortedLeft = mergeSort(left);
        sortedRight = mergeSort(right);
        sorted = simpleMerge(sortedLeft, sortedRight);
        return sorted;
    }

    private List<T> simpleMerge(List<T> sortedLeft, List<T> sortedRight) {
        List<T> result = Lists.newArrayList();
        int left = 0;
        int right = 0;
        while (result.size() < (sortedLeft.size() + sortedRight.size())) {
            if (sortedLeft.size() > left && sortedRight.size() > right) {
                T x = sortedLeft.get(left);
                T y = sortedRight.get(right);
                if (x.compareTo(y) <= 0) {
                    result.add(x);
                    left++;
                } else {
                    result.add(y);
                    right++;
                }

            } else if (sortedLeft.size() > left) {
                result.add(sortedLeft.get(left++));
            } else if (sortedRight.size() > right) {
                result.add(sortedRight.get(right++));
            }
        }
        return result;
    }
}
