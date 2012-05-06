package com.funkyganesha.sort;

import java.util.List;

public interface Sorter<T extends Comparable<? super T>> {
    /**
     * Sort values in ascending order
     *
     * @param values
     */
    public List<T> sort(List<T> values);

}
