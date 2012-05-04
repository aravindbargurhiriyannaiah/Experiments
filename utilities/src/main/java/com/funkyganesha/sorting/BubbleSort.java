package com.funkyganesha.sorting;

import org.apache.commons.lang.ArrayUtils;

import com.google.common.base.Preconditions;

/**
 *
 */
public class BubbleSort implements Sorter {

    @Override
    public void sort(int[] ints) {
        Preconditions.checkArgument(ArrayUtils.isNotEmpty(ints), "The input is either null or empty");
        sortArray(ints);
    }

    private void sortArray(int[] ints) {
        boolean swapped = true;
        int j = 0;
        int temp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < ints.length - j; i++) {
                if (ints[i] > ints[i + 1]) {
                    temp = ints[i];
                    ints[i] = ints[i + 1];
                    ints[i + 1] = temp;
                    swapped = true;
                }
            }
        }
    }
}
