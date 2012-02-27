package com.funkyganesha;

/**
 *
 */
public interface FibonacciSeriesGenerator {
    /**
     * @param number
     * @return the first N fibonacci series starting from 0
     *         <br/>
     *         Eg.
     *         <ol>
     *         <li>generateFirst(10) = 0, 1, 1, 2, 3, 5, 8, 13, 21, 34</li>
     *         <li>generateFirst(1) = 0</li>
     *         <li>generateFirst(-1) = null</li>
     *         <li>generateFirst(0) = null</li>
     *         </ol>
     */
    int[] generateFirstNFibonacciSeriesNumbers(int number);

    /**
     * @param number
     * @return the Fibonacci series starting from 0 until the provided number param.
     *         <br/>
     *         Eg.
     *         <ol>
     *         <li>generateUntil (80) = 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89</li>
     *         <li>generateUntil(8) = 0, 1, 2, 3, 5, 8</li>
     *         <li>generateUntil(-1) = null</li>
     *         <li>generateUntil(0) = 0</li>
     *         </ol>
     */
    int[] generateFibonacciSeriesUntil(int number);
}
