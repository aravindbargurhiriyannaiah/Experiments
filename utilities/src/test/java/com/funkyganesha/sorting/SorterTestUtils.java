package com.funkyganesha.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.google.common.primitives.Ints;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.fail;

/**
 *
 */
public class SorterTestUtils {


    public static void compareAndAssertArrays(int[] expected, int[] actual) {
        assertNotNull("The result should not be null", actual);
        assertEquals("Incorrect number of elements in the result.", expected.length, actual.length);
        Arrays.sort(expected);
        for (int i = 0; i < expected.length - 1; i++) {
            assertEquals("Incorrect value.", expected[i], actual[i]);
        }
    }

    public static void compareAndAssertLists(List<Integer> expected, List<Integer> actual) {
        assertNotNull("The result should not be null", actual);
        assertEquals("Incorrect number of elements in the result", expected.size(), actual.size());
        Collections.sort(expected);
        int count = 0;
        for (Integer i : expected) {
            assertEquals("Incorrect value", i, actual.get(count++));
        }
    }

    public static void compareAndAssertIfTheArrayIsSortedInAscendingOrder(int[] ints) {
        for (int i = 0; i < ints.length - 1; i++) {
            if (ints[i] > ints[i + 1]) {
                fail("Invalid value at index [" + i + "]");
            }
        }
    }

    public static void compareAndAssertIfTheArrayIsSortedInAscendingOrder(List<Integer> list) {
        int[] ints = Ints.toArray(list);
        compareAndAssertIfTheArrayIsSortedInAscendingOrder(ints);
    }
}
