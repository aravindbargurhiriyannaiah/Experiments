package com.funkyganesha;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class LcmGcdFinderTest {
    @Test
    public void testComputeLcm_success_scenarios() throws Exception {
        assertEquals(0, LcmGcdFinder.computeLcm(0L, 0L));
        assertEquals(2, LcmGcdFinder.computeLcm(0L, 2L));
        assertEquals(6, LcmGcdFinder.computeLcm(3L, 2L));
        assertEquals(20, LcmGcdFinder.computeLcm(4L, 5L));
        assertEquals(1260, LcmGcdFinder.computeLcm(60L, 18L, 28L));
        assertEquals(198, LcmGcdFinder.computeLcm(6L, 11L, 18L));
        assertEquals(120, LcmGcdFinder.computeLcm(8L, 3L, 5L));
        assertEquals(10, LcmGcdFinder.computeLcm(10L));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testComputeLcm_null_input() {
        LcmGcdFinder.computeLcm(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testComputeGcdWithNullInput() {
        LcmGcdFinder.computeGcd(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testComputeLcm_empty_input() {
        LcmGcdFinder.computeLcm();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testComputeGcd_empty_input() {
        LcmGcdFinder.computeGcd();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testComputeLcm_negative_input() {
        LcmGcdFinder.computeLcm(3L, 4L, -1L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testComputeGcd_negative_numbers() {
        LcmGcdFinder.computeGcd(3L, 2L, -9L);
    }

    @Test
    public void testComputeGcd_valid_cases() {
        assertEquals(6, LcmGcdFinder.computeGcd(84L, 18L));
        assertEquals(4, LcmGcdFinder.computeGcd(8L, 12L));
        assertEquals(2, LcmGcdFinder.computeGcd(12L, 28L, 18L));
        assertEquals(5, LcmGcdFinder.computeGcd(5L));
    }
}
