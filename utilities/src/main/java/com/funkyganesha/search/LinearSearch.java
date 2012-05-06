package com.funkyganesha.search;

import org.apache.commons.lang.ArrayUtils;

import com.google.common.base.Preconditions;

public class LinearSearch implements Searcher {
    @Override
    public boolean search(int element, int[] array) {
        Preconditions.checkArgument(ArrayUtils.isNotEmpty(array), "Input is either null or empty");
        boolean result = false;
        for (int i : array) {
            if (i == element) {
                result = true;
                break;
            }
        }
        return result;
    }
}
