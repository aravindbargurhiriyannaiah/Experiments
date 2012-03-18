package com.funkyganesha;

import java.util.List;

import com.google.common.collect.Lists;
import com.google.common.primitives.Longs;

/**
 *
 */
public class RecursiveFibonacciSeriesGenerator implements FibonacciSeriesGenerator {
    public long[] generateFirstNFibonacciSeriesNumbers(int number) {
        long[] result = null;
        if (number > 0) {
            List<Long> longs = Lists.newArrayList();
            for (int i = 0; i < number; i++) {
                longs.add(fibonacci(i));
            }
            result = Longs.toArray(longs);
        }
        return result;
    }

    public long[] generateFibonacciSeriesUntil(int number) {
        long[] result = null;
        if (number > 0) {
            List<Long> longs = Lists.newArrayList();
            for (int i = 0; i < number; i++) {
                long fibonacciNumber = fibonacci(i);
                if (fibonacciNumber <= number) {
                    longs.add(fibonacciNumber);
                }
            }
            result = Longs.toArray(longs);
        }

        return result;
    }

    private long fibonacci(int number) {
        if (number == 0) {
            return 0;
        } else
        if(number == 1 ) {
            return 1;
        } else {
            return fibonacci(number - 1) + fibonacci((number - 2));
        }
    }
}
