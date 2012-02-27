package com.funkyganesha;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 *
 */
public class IterativeFibonacciSeriesGeneratorTest {
    private FibonacciSeriesGenerator fibonacciSeriesGenerator;
    private int[] expectedFibonacciSeries = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377};

    @Before
    public void setup() {
        fibonacciSeriesGenerator = new IterativeFibonacciSeriesGenerator();
    }

    @Test
    public void testGenerateFirstNFibonacciSeriesNumbers_invalidNumber() {
        int[] ints = fibonacciSeriesGenerator.generateFirstNFibonacciSeriesNumbers(-1);
        assertAsNull(ints);
        ints = fibonacciSeriesGenerator.generateFirstNFibonacciSeriesNumbers(0);
        assertAsNull(ints);
    }

    @Test
    public void testGenerateFirstNFibonacciSeriesNumbers_oneNumber() {
        int[] ints = fibonacciSeriesGenerator.generateFirstNFibonacciSeriesNumbers(1);
        assertEquals("Invalid number of fibonacci numbers returned", 1, ints.length);
        validateFibonacciNumbers(ints);
        assertEquals("Incorrect first number.", 0, ints[0]);
        ints = fibonacciSeriesGenerator.generateFirstNFibonacciSeriesNumbers(2);
        assertEquals("Invalid number of fibonacci numbers returned", 2, ints.length);
        validateFibonacciNumbers(ints);
    }

    @Test
    public void testGenerateFirstNFibonacciSeriesNumbers_largeNumber() {
        int[] ints = fibonacciSeriesGenerator.generateFirstNFibonacciSeriesNumbers(10);
        assertEquals("Invalid number of fibonacci numbers returned", 10, ints.length);
        validateFibonacciNumbers(ints);
    }

    private void validateFibonacciNumbers(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            assertEquals("Incorrect fibonacci number at index " + i, expectedFibonacciSeries[i], ints[i]);
        }
    }

    @Test
    public void testGenerateFibonacciSeriesUntil_negativeNumber() {
        int[] ints = fibonacciSeriesGenerator.generateFibonacciSeriesUntil(-1);
        assertAsNull(ints);
    }

    @Test
    public void testGenerateFibonacciSeriesUntil_zero() {
        int[] ints = fibonacciSeriesGenerator.generateFibonacciSeriesUntil(0);
        assertNotNull("Actual value is null. Should have one number.", ints);
        assertEquals("Incorrect size of returned valus.", 1, ints.length);
        assertEquals("Incorrect fibonacci number returned.", 0, ints[0]);
    }

    @Test
    public void testGenerateFibonacciSeriesUntil_one() {
        int[] ints = fibonacciSeriesGenerator.generateFibonacciSeriesUntil(1);
        assertNotNull("Actual value is null. Should have two numbers.", ints);
        assertEquals("Incorrect size of returned valus.", 2, ints.length);
        assertEquals("Incorrect fibonacci number returned.", 0, ints[0]);
        assertEquals("Incorrect fibonacci number returned.", 1, ints[1]);
    }

    @Test
    public void testGenerateFibonacciSeriesUntil_100() {
        int[] ints = fibonacciSeriesGenerator.generateFibonacciSeriesUntil(100);
        assertNotNull("Actual value is null.", ints);
        assertEquals("Incorrect size of returned valus.", 12, ints.length);
        validateFibonacciNumbers(ints);
    }

    @Test
    public void testGenerateFibonacciSeriesUntil_8() {
        int[] ints = fibonacciSeriesGenerator.generateFibonacciSeriesUntil(8);
        assertNotNull("Actual value is null.", ints);
        assertEquals("Incorrect size of returned valus.", 7, ints.length);
        validateFibonacciNumbers(ints);
    }

    private void assertAsNull(int[] ints) {
        assertNull("Should have been null, but is not.", ints);
    }
}
