package com.funkyganesha.search;

import org.apache.commons.lang.ArrayUtils;

import com.google.common.base.Preconditions;

public class BinarySearch implements Searcher {
    private int element;
    private int[] array;
    private boolean isFound;

    @Override
    public boolean search(int element, int[] array) {
        Preconditions.checkArgument(ArrayUtils.isNotEmpty(array), "The input is either null or empty");
        this.element = element;
        this.array = array;
        binarySearch(0, array.length - 1);
        return isFound;
    }

    private void binarySearch(int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (element < array[mid]) {
                high = mid - 1;
            }
            else if (element > array[mid]) {
                low = mid + 1;
            } else {
                isFound = true;
                return;
            }
        }
    }
}
