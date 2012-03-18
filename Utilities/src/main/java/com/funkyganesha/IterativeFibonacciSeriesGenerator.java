package com.funkyganesha;

import java.util.List;

import com.google.common.collect.Lists;
import com.google.common.primitives.Longs;

public class IterativeFibonacciSeriesGenerator implements FibonacciSeriesGenerator {
    public long[] generateFirstNFibonacciSeriesNumbers(int number) {
        long[] result = null;
        if (number > 0) {
            List<Long> fibonacciNumbers = Lists.newArrayList();
            long first = 0;
            if (number >= 1) {
                fibonacciNumbers.add(first);
            }
            long next = 1;
            if (number >= 2 && fibonacciNumbers.size() < number) {
                fibonacciNumbers.add(next);
            }
            int index;
            while (fibonacciNumbers.size() < number) {
                index = fibonacciNumbers.size();
                fibonacciNumbers.add(fibonacciNumbers.get(index - 1) + fibonacciNumbers.get(index - 2));
            }
            result = Longs.toArray(fibonacciNumbers);
        }
        return result;
    }

    public long[] generateFibonacciSeriesUntil(int number) {
        long[] result = null;
        if (number >= 0) {
            List<Long> fibonacciNumbers = Lists.newArrayList();
            long firstNumber = 0;
            if (number >= 0) {
                fibonacciNumbers.add(firstNumber);
            }
            long secondNumber = 1;
            if (number >= 1) {
                fibonacciNumbers.add(secondNumber);
            }
            int index = fibonacciNumbers.size();
            long nextNumber;
            while (fibonacciNumbers.get(index - 1) < number) {
                nextNumber = fibonacciNumbers.get(index - 1) + fibonacciNumbers.get(index - 2);
                if (nextNumber <= number) {
                    fibonacciNumbers.add(nextNumber);
                } else {
                    break;
                }
                index = fibonacciNumbers.size();
            }
            result = Longs.toArray(fibonacciNumbers);
        }
        return result;
    }
}
