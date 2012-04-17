package com.funkyganesha;

import org.junit.Test;

import java.util.Map;

import static junit.framework.Assert.assertEquals;

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
}
