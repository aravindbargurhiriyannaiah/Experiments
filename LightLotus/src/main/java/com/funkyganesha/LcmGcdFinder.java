package com.funkyganesha;

import com.funkyganesha.exception.LightLotusException;
import com.google.common.collect.Sets;
import org.apache.commons.lang.ArrayUtils;

import java.util.Set;

public class LcmGcdFinder {

    /**
     * Computes GCD of the given numbers by GCD (a, b, ...) = (a * b * ...) / lcm(a, b, ...)
     *
     * @param longs
     * @return
     * @throws LightLotusException
     */
    public static long computeGcd(Long... longs) throws LightLotusException {
        long gcd;
        validateInput(longs);
        gcd = longs[0];
        long lcm = 0;
        for (long integer : longs) {
            isNegative(integer, gcd);
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
     * @param longs
     * @return
     * @throws LightLotusException
     */
    public static long computeLcm(Long... longs) throws LightLotusException {
        long lcm = 0;
        validateInput(longs);
        lcm = longs[0];
        if (longs.length > 1) {
            for (long integer : longs) {
                isNegative(lcm, integer);
                lcm = findLcm(integer, lcm);
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

    private static void isNegative(long first, long second) {
        if ((Long.signum(second) == -1) || (Long.signum(first) == -1)) {
            throw new LightLotusException("Cannot workd with negative numbers. First number = " + first + ", Second number = " + second);
        }
    }

    private static void validateInput(Long... longs) {
        if (ArrayUtils.isEmpty(longs)) {
            throw new LightLotusException("Cannot continue. Input array is either empty or null.");
        }
    }
}
