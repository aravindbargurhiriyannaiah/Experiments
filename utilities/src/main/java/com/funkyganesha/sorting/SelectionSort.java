package com.funkyganesha.sorting;

import org.apache.commons.lang.ArrayUtils;

import com.google.common.base.Preconditions;

public class SelectionSort implements Sorter {

    @Override
    public void sort(int[] ints) {
        Preconditions.checkArgument(ArrayUtils.isNotEmpty(ints), "The input is either null or empty");
        int minIndex;
        for (int i = 0; i < ints.length; i++) {
            minIndex = findIndexOfSmallestElement(ints, i);
            swap(ints, minIndex, i);
        }
    }

    private void swap(int[] workingArray, int minIndex, int swapIndex) {
        int temp = workingArray[minIndex];
        workingArray[minIndex] = workingArray[swapIndex];
        workingArray[swapIndex] = temp;
    }

    private int findIndexOfSmallestElement(int[] workingArray, int startIndex) {
        int minIndex = startIndex;
        for (int i = startIndex; i < workingArray.length; i++) {
            minIndex = (workingArray[i] < workingArray[minIndex]) ? i : minIndex;
        }
        return minIndex;
    }
}
