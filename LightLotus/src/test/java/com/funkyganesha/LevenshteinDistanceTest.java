package com.funkyganesha;

import com.funkyganesha.exception.LightLotusException;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class LevenshteinDistanceTest {

    public static final String INCORRECT_LEVENSHTEIN_DISTANCE_RETURNED = "Incorrect Levenshtein Distance returned.";

    @Test
    public void testCalculateLevenshteinDistance_valid_inputs() {
        assertEquals(INCORRECT_LEVENSHTEIN_DISTANCE_RETURNED, 6, LevenshteinDistance.calculateLevenshteinDistance("aravind", "bargur"));
        assertEquals(INCORRECT_LEVENSHTEIN_DISTANCE_RETURNED, 3, LevenshteinDistance.calculateLevenshteinDistance("kitten", "sitting"));
        assertEquals(INCORRECT_LEVENSHTEIN_DISTANCE_RETURNED, 3, LevenshteinDistance.calculateLevenshteinDistance("Saturday", "Sunday"));
    }

    @Test(expected = LightLotusException.class)
    public void testCalculateLevenshteinDistance_both_null_inputs() {
        LevenshteinDistance.calculateLevenshteinDistance(null, null);
    }

    @Test
    public void testCalculateLevenshteinDistance_firstString_empty() {
        assertEquals(INCORRECT_LEVENSHTEIN_DISTANCE_RETURNED, "aravind".length(), LevenshteinDistance.calculateLevenshteinDistance("", "aravind"));
    }

    @Test
    public void testCalculateLevenshteinDistance_secondString_empty() {
        assertEquals(INCORRECT_LEVENSHTEIN_DISTANCE_RETURNED, "aravind".length(), LevenshteinDistance.calculateLevenshteinDistance("aravind", ""));
    }
}
