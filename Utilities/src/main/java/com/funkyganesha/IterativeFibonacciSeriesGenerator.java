package com.funkyganesha;

import java.util.List;

import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;

public class IterativeFibonacciSeriesGenerator implements FibonacciSeriesGenerator {
    public int[] generateFirstNFibonacciSeriesNumbers(int number) {
        int[] result = null;
        if (number > 0) {
            List<Integer> fibonacciNumbers = Lists.newArrayList();
            int first = 0;
            if (number >= 1) {
                fibonacciNumbers.add(first);
            }
            int next = 1;
            if (number >= 2 && fibonacciNumbers.size() < number) {
                fibonacciNumbers.add(next);
            }
            int index;
            while (fibonacciNumbers.size() < number) {
                index = fibonacciNumbers.size();
                fibonacciNumbers.add(fibonacciNumbers.get(index - 1) + fibonacciNumbers.get(index - 2));
            }
            result = Ints.toArray(fibonacciNumbers);
        }
        return result;
    }

    public int[] generateFibonacciSeriesUntil(int number) {
        int[] result = null;
        if (number >= 0) {
            List<Integer> fibonacciNumbers = Lists.newArrayList();
            int firstNumber = 0;
            if (number >= 0) {
                fibonacciNumbers.add(firstNumber);
            }
            int secondNumber = 1;
            if (number >= 1) {
                fibonacciNumbers.add(secondNumber);
            }
            int index = fibonacciNumbers.size();
            int nextNumber;
            while (fibonacciNumbers.get(index - 1) < number) {
                nextNumber = fibonacciNumbers.get(index - 1) + fibonacciNumbers.get(index - 2);
                if (nextNumber <= number) {
                    fibonacciNumbers.add(nextNumber);
                } else {
                    break;
                }
                index = fibonacciNumbers.size();
            }
            result = Ints.toArray(fibonacciNumbers);
        }
        return result;
    }
}
