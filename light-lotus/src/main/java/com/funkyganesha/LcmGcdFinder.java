package com.funkyganesha;

import java.util.Set;

import org.apache.commons.lang.ArrayUtils;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;

public class LcmGcdFinder {

    /**
     * Computes GCD of the given numbers by GCD (a, b, ...) = (a * b * ...) / lcm(a, b, ...)
     *
     * @param numbers
     * @return
     */
    public static long computeGcd(Long... numbers) {
        Preconditions.checkArgument(ArrayUtils.isNotEmpty(numbers), "The input is either empty or null.");
        Preconditions.checkArgument(areAllPositiveNumbers(numbers), "There are negative numbers. Cannot continue.");
        long gcd = numbers[0];
        long lcm;
        for (long integer : numbers) {
            lcm = findLcm(integer, gcd);
            gcd = (integer * gcd) / lcm;
        }
        return gcd;
    }

    /**
     * Computes the LCM of the given number by
     * <ol>
     * <li>List all the multiples of all the numbers in ascending order.</li>
     * <li>Pick the first commonly occurring number from all the lists.</li>
     * </ol>
     *
     * @param numbers
     * @return
     */
    public static long computeLcm(Long... numbers) {
        Preconditions.checkArgument(ArrayUtils.isNotEmpty(numbers), "The input is either empty or null.");
        Preconditions.checkArgument(areAllPositiveNumbers(numbers), "There are negative numbers. Cannot continue.");
        long lcm = numbers[0];
        if (numbers.length > 1) {
            for (long number : numbers) {
                lcm = findLcm(number, lcm);
            }
        }
        return lcm;
    }

    private static long findLcm(long n, long m) {
        long lcm;
        if (m == 0 || n == 0) {
            lcm = m;
            if (m == 0) {
                lcm = n;
            }
        } else {
            Set<Long> set = Sets.newHashSet();
            long resultN;
            long resultM;
            int counter = 1;
            while (true) {
                resultN = n * counter;
                resultM = m * counter;
                if (!set.add(resultN)) {
                    lcm = resultN;
                    break;
                } else if (!set.add(resultM)) {
                    lcm = resultM;
                    break;
                }
                counter++;
            }
        }
        return lcm;
    }

    private static boolean areAllPositiveNumbers(Long[] longs) {
        boolean result = true;
        for (long l : longs) {
            if (Long.signum(l) == -1) {
                result = false;
                break;
            }
        }
        return result;
    }
}
