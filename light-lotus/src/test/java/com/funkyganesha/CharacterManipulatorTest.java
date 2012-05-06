package com.funkyganesha;

import java.util.Map;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class CharacterManipulatorTest {

    @Test
    public void testFindMaxOccurringCharacter_valid_cases() {
        Map.Entry<Character, Integer> entry = CharacterManipulator.findMaxOccurringCharacter("aravind");
        assertEquals(Integer.valueOf(2), entry.getValue());
        assertEquals(Character.valueOf('a'), entry.getKey());
        entry = CharacterManipulator.findMaxOccurringCharacter("aravind Bargur Hiriyannaiah");
        assertEquals(Integer.valueOf(6), entry.getValue());
        assertEquals(Character.valueOf('a'), entry.getKey());
    }

    @Test
    public void testFindMaxOccurringCharacter_incorrect_inputs() {
        assertEquals(null, CharacterManipulator.findMaxOccurringCharacter(null));
        assertEquals(null, CharacterManipulator.findMaxOccurringCharacter(""));
    }

    @Test
    public void testFindAndRemoveDuplicateCharacters() {
        String[] input = {"aravind bargur hiriyannaiah", "aaa aaa aaa"};
        String[] output = CharacterManipulator.findAndRemoveDuplicateCharacters(input);
        assertNotNull("The result should not be null", output);
        assertEquals("Incorrect size of the output.", input.length, output.length);
        assertEquals("Invalid value returned", "arvind bguhy", output[0]);
        assertEquals("Invalid value returned", "a ", output[1]);
    }
}
