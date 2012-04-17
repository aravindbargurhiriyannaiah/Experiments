package com.funkyganesha;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

/**
 *
 */
public class RecursiveFibonacciSeriesGeneratorTest {
    private FibonacciSeriesGenerator fibonacciSeriesGenerator;
    private long[] expectedFibonacciSeries = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377};

    @Before
    public void setUp() {
        fibonacciSeriesGenerator = new RecursiveFibonacciSeriesGenerator();
    }

    @Test
    public void testGenerateFirstNFibonacciSeriesNumbers() {
        long[] actualFibonacciSeries = fibonacciSeriesGenerator.generateFirstNFibonacciSeriesNumbers(5);
        verifyFibonacciNumbers(actualFibonacciSeries, 5);
    }

    @Test
    public void testGenerateFirstNFibonacciSeriesNumbers_NegativeNumber() {
        assertNull("Returned result should be null.", fibonacciSeriesGenerator.generateFirstNFibonacciSeriesNumbers(-1));
    }

    @Test
    public void testGenerateFirstNFibonacciSeriesNumbers_Zero() {
        assertNull("Returned result should be null", fibonacciSeriesGenerator.generateFirstNFibonacciSeriesNumbers(0));
    }

    @Test
    public void testGenerateFirstNFibonacciSeriesNumbers_One() {
        long[] actualFibonacciNumbers = fibonacciSeriesGenerator.generateFirstNFibonacciSeriesNumbers(1);
        verifyFibonacciNumbers(actualFibonacciNumbers, 1);
    }

    @Test
    public void testGenerateFibonacciSeriesUntil() {
        long[] actualFibonacciNumbers = fibonacciSeriesGenerator.generateFibonacciSeriesUntil(10);
        verifyFibonacciNumbers(actualFibonacciNumbers, 7);
    }

    @Test
    public void testGenerateFibonacciSeriesUntil_NegativeNumber() {
        assertNull("Returned result should have been null", fibonacciSeriesGenerator.generateFibonacciSeriesUntil(-1));
    }

    @Test
    public void testGenerateFibonacciSeriesUntil_Zero() {
        assertNull("Returned result should have been null", fibonacciSeriesGenerator.generateFibonacciSeriesUntil(0));
    }

    @Test
    public void testGenerateFibonacciSeriesUntil_One() {
        long[] actualFibonacciSeries = fibonacciSeriesGenerator.generateFibonacciSeriesUntil(1);
        verifyFibonacciNumbers(actualFibonacciSeries, 1);
    }

    private void verifyFibonacciNumbers(long[] actualFibonacciSeries, int actualLength) {
        assertEquals("Invalid number of Fibonacci numbers", actualLength, actualFibonacciSeries.length);
        for (int i = 0; i < actualFibonacciSeries.length; i++) {
            assertEquals("Fibonacci number at " + i + " is incorrect.", expectedFibonacciSeries[i], actualFibonacciSeries[i]);
        }
    }
}
