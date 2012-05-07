package com.funkyganesha;

import java.util.Collections;
import java.util.List;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

public class SeriesGenerator {
    /**
     * Given a positive integer A, the goal is to construct the shortest possible sequence of integers ending with A, using the following rules:
     * <ol>
     * <li>The first element of the sequence is 1</li>
     * <li>Each of the successive elements is the sum of any two preceding elements (adding a single element to itself is also permissible),</li>
     * <li>Each element is larger than all the preceding elements; that is, the sequence is increasing.</li>
     * </ol>
     * Example - for A = 42, the possible solutions are
     * <ol>
     *     <li>1, 2, 3, 6, 12, 24, 30, 42</li>
     *     <li>1, 2, 4, 5, 8, 16, 21, 42</li>
     *     <li>1, 2, 4, 5, 10, 20, 21, 42</li>
     * </ol>
     *
     * @param finalNumber
     * @return
     */
    public static List<Integer> generateSeries(int finalNumber) {
        Preconditions.checkArgument(finalNumber >= 1, "This is an invalid input");
        List<Integer> result = Lists.newArrayList();
        //Start with the final number and work backwards.
        result.add(finalNumber);
        int number = finalNumber;
        int nextNumber;
        while (number != 1) {
            if (isEven(number)) {
                nextNumber = number / 2;
            } else {
                nextNumber = number - 1;
            }
            number = nextNumber;
            result.add(nextNumber);
        }
        Collections.reverse(result);
        return result;
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
