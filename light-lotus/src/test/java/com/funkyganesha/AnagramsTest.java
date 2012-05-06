package com.funkyganesha;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 *
 */
public class AnagramsTest {

    public static final List<String> INPUT = Arrays.asList("gOOd", "aravind", "Nob<el", "dogO", "<leboN", "a;rav1nd", "aravn1d;");

    @Test
    public void testFindAnagramsIgnoreCase() throws Exception {
        List<List<String>> anagramsIgnoreCase = Anagrams.findAnagramsIgnoreCase(INPUT);
        assertNotNull("The result should not be null", anagramsIgnoreCase);
        assertEquals("Incorect number of anagrams found", 3, anagramsIgnoreCase.size());
        List<String> strings = anagramsIgnoreCase.get(0);
        assertEquals("Incorrect number of anagrams returned", 2, strings.size());
        strings = anagramsIgnoreCase.get(1);
        assertEquals("Incorrect number of anagrams returned", 2, strings.size());
        strings = anagramsIgnoreCase.get(2);
        assertEquals("Incorrect number of anagrams returned", 2, strings.size());
    }

    @Test
    public void testFindAnagrams() throws Exception {
        List<List<String>> anagramsIgnoreCase = Anagrams.findAnagrams(INPUT);
        assertNotNull("The result should not be null", anagramsIgnoreCase);
        assertEquals("Incorect number of anagrams found", 2, anagramsIgnoreCase.size());
        List<String> strings = anagramsIgnoreCase.get(0);
        assertEquals("Incorrect number of anagrams returned", 2, strings.size());
        strings = anagramsIgnoreCase.get(1);
        assertEquals("Incorrect number of anagrams returned", 2, strings.size());
    }
}
