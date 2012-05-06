package com.funkyganesha.sort.util;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.google.common.base.Preconditions;

public class SorterUtil {

    public static <T> void swap(List<T> list, int i, int j) {
        Preconditions.checkArgument(CollectionUtils.isNotEmpty(list), "Array is either empty or null.");
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
