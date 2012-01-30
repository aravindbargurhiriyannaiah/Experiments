package com.funkyganesha;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BoyerMooreStringMatcherTest {
    @Test
    public void testMatch_with_valid_strings() {
        //Example from http://www.movsd.com/bm.htm
        assertTrue(BoyerMooreStringMatcher.matchIgnoreCase("This is a test of the Boyer Moore algorithm", "algorithm"));
    }

    @Test
    public void testMatch_with_valid_string_another_string() {
        //Example from the actual paper.
        assertTrue(BoyerMooreStringMatcher.matchIgnoreCase("WHICH FINALLY HALTS.  AT THAT POINT...", "AT THAT"));
    }

    @Test
    public void testMatch_with_valid_string_no_match() {
        assertFalse(BoyerMooreStringMatcher.matchIgnoreCase("This is a test of the Boyer Moore algorithm", "plgorithm"));
    }


    @Test
    public void testMatch_with_smaller_strings() {
        assertFalse(BoyerMooreStringMatcher.matchIgnoreCase("experiment", "et"));
    }

    @Test
    public void testMatch_with_pattern_longer_than_text() {
        assertFalse(BoyerMooreStringMatcher.matchIgnoreCase("et", "experiment"));
    }

    @Test
    public void testMatch_with_fair_length_pattern() {
        //Example from http://www.cs.utexas.edu/~moore/best-ideas/string-searching/fstrpos-example.html
        assertTrue(BoyerMooreStringMatcher.matchIgnoreCase("here is a simple example", "example"));
    }

    @Test
    public void testMatch_with_repeated_characters() {
        //Example from http://www.inf.fh-flensburg.de/lang/algorithmen/pattern/bmen.htm
        assertFalse(BoyerMooreStringMatcher.matchIgnoreCase("abbadabacba", "babac"));
    }

    @Test
    public void testMatch_with_repeated_characters_another_sample() {
        //Example from http://www.inf.fh-flensburg.de/lang/algorithmen/pattern/bmen.htm
        assertTrue(BoyerMooreStringMatcher.matchIgnoreCase("abbababacba ", "babac"));
    }


    @Test
    public void testMatch_with_null_text_null_pattern() {
        assertFalse("Should have been false as the inputs are null/empty", BoyerMooreStringMatcher.matchIgnoreCase(null, null));
    }

    @Test
    public void testMatch_with_empty_text_empty_pattern() {
        assertFalse("Should have been false as the inputs are null/empty", BoyerMooreStringMatcher.matchIgnoreCase("", ""));
    }

    @Test
    public void testMatch_with_null_text_empty_pattern() {
        assertFalse("Should have been false as the inputs are null/empty", BoyerMooreStringMatcher.matchIgnoreCase(null, ""));
    }

    @Test
    public void testMatch_with_empty_text_null_pattern() {
        assertFalse("Should have been false as the inputs are null/empty", BoyerMooreStringMatcher.matchIgnoreCase("", null));
    }
}
