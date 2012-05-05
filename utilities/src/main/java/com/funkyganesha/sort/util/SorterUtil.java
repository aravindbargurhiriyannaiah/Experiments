package com.funkyganesha.sort.util;

import org.apache.commons.lang.ArrayUtils;

import com.google.common.base.Preconditions;

public class SorterUtil {

    public static void swap(int[] integers, int i, int j) {
        Preconditions.checkArgument(ArrayUtils.isNotEmpty(integers), "Array is either empty or null.");
        int temp = integers[i];
        integers[i] = integers[j];
        integers[j] = temp;
    }
}
