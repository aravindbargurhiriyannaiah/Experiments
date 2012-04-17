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
    private long[] expectedFibonacciSeries = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377};

    @Before
    public void setup() {
        fibonacciSeriesGenerator = new IterativeFibonacciSeriesGenerator();
    }

    @Test
    public void testGenerateFirstNFibonacciSeriesNumbers_invalidNumber() {
        long[] longs = fibonacciSeriesGenerator.generateFirstNFibonacciSeriesNumbers(-1);
        assertAsNull(longs);
        longs = fibonacciSeriesGenerator.generateFirstNFibonacciSeriesNumbers(0);
        assertAsNull(longs);
    }

    @Test
    public void testGenerateFirstNFibonacciSeriesNumbers_oneNumber() {
        long[] ints = fibonacciSeriesGenerator.generateFirstNFibonacciSeriesNumbers(1);
        assertEquals("Invalid number of fibonacci numbers returned", 1, ints.length);
        validateFibonacciNumbers(ints);
        assertEquals("Incorrect first number.", 0, ints[0]);
        ints = fibonacciSeriesGenerator.generateFirstNFibonacciSeriesNumbers(2);
        assertEquals("Invalid number of fibonacci numbers returned", 2, ints.length);
        validateFibonacciNumbers(ints);
    }

    @Test
    public void testGenerateFirstNFibonacciSeriesNumbers_largeNumber() {
        long[] longs = fibonacciSeriesGenerator.generateFirstNFibonacciSeriesNumbers(10);
        assertEquals("Invalid number of fibonacci numbers returned", 10, longs.length);
        validateFibonacciNumbers(longs);
    }

    private void validateFibonacciNumbers(long[] longs) {
        for (int i = 0; i < longs.length; i++) {
            assertEquals("Incorrect fibonacci number at index " + i, expectedFibonacciSeries[i], longs[i]);
        }
    }

    @Test
    public void testGenerateFibonacciSeriesUntil_negativeNumber() {
        long[] longs = fibonacciSeriesGenerator.generateFibonacciSeriesUntil(-1);
        assertAsNull(longs);
    }

    @Test
    public void testGenerateFibonacciSeriesUntil_zero() {
        long [] longs = fibonacciSeriesGenerator.generateFibonacciSeriesUntil(0);
        assertNotNull("Actual value is null. Should have one number.", longs);
        assertEquals("Incorrect size of returned value.", 1, longs.length);
        assertEquals("Incorrect fibonacci number returned.", 0, longs[0]);
    }

    @Test
    public void testGenerateFibonacciSeriesUntil_one() {
        long [] longs = fibonacciSeriesGenerator.generateFibonacciSeriesUntil(1);
        assertNotNull("Actual value is null. Should have two numbers.", longs);
        assertEquals("Incorrect size of returned value.", 2, longs.length);
        assertEquals("Incorrect fibonacci number returned.", 0, longs[0]);
        assertEquals("Incorrect fibonacci number returned.", 1, longs[1]);
    }

    @Test
    public void testGenerateFibonacciSeriesUntil_100() {
        long[] longs = fibonacciSeriesGenerator.generateFibonacciSeriesUntil(100);
        assertNotNull("Actual value is null.", longs);
        assertEquals("Incorrect size of returned value.", 12, longs.length);
        validateFibonacciNumbers(longs);
    }

    @Test
    public void testGenerateFibonacciSeriesUntil_8() {
        long [] longs = fibonacciSeriesGenerator.generateFibonacciSeriesUntil(8);
        assertNotNull("Actual value is null.", longs);
        assertEquals("Incorrect size of returned value.", 7, longs.length);
        validateFibonacciNumbers(longs);
    }

    private void assertAsNull(long[] longs) {
        assertNull("Should have been null, but is not.", longs);
    }
}
