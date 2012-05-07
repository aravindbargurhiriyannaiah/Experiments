package com.funkyganesha;

import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SeriesGeneratorTest {


    @Test(expected = IllegalArgumentException.class)
    public void testGenerateSeriesWithNegativeNumber() {
        SeriesGenerator.generateSeries(-1);
    }

    @Test
    public void testGenerateSeries() {
        int finalNumber = 30;
        List<Integer> integers = SeriesGenerator.generateSeries(finalNumber);
        assertResult(finalNumber, integers);
        finalNumber = 42;
        integers = SeriesGenerator.generateSeries(finalNumber);
        assertResult(finalNumber, integers);
    }

    private void assertResult(int finalNumber, List<Integer> integers) {
        assertNotNull("The result should not be null.", integers);
        assertEquals("The first number should be 1", new Integer(1), integers.get(0));
        assertEquals("The last number should be the test input", new Integer(finalNumber), integers.get(integers.size() - 1));
        System.out.println(integers);
    }
}
