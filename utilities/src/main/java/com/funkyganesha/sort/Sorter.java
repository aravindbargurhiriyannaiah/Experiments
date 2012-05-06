package com.funkyganesha.sort;

public interface Sorter <T extends Comparable<? super T>> {
    public void sort(T[] values);
}
