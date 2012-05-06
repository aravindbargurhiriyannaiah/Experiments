package com.funkyganesha.sort.util;

import org.apache.commons.lang.ArrayUtils;

import com.google.common.base.Preconditions;

public class SorterUtil <T extends Comparable<? super T>> {

    public static <T> void swap(T[] comparables, int i, int j) {
        Preconditions.checkArgument(ArrayUtils.isNotEmpty(comparables), "Array is either empty or null.");
        T temp = comparables[i];
        comparables[i] = comparables[j];
        comparables[j] = temp;
    }
}
