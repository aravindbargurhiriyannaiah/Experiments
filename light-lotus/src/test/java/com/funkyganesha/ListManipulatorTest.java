package com.funkyganesha;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

public class ListManipulatorTest {
    @Test
    public void testReverseList_null_list() {
        assertNull(ListManipulator.reverseList(null));
    }

    @Test
    public void testReverseList_empty_list() {
        assertEquals(0, ListManipulator.reverseList(new ArrayList<Character>()).size());
    }

    @Test
    public void testReverseList_valid_input_only_one_character() {
        List<Character> characters = Lists.newArrayList();
        characters.add('a');
        List<Character> resultList = ListManipulator.reverseList(characters);
        assertEquals(1, resultList.size());
        assertEquals(Character.valueOf('a'), resultList.get(0));
    }

    @Test
    public void testReverseList_valid_input_with_two_characters() {
        List<Character> characters = Lists.newArrayList();
        characters.add('a');
        characters.add('b');
        List<Character> resultList = ListManipulator.reverseList(characters);
        assertEquals(3, resultList.size());
        assertEquals(Character.valueOf('a'), resultList.get(0));
        assertEquals(Character.valueOf('b'), resultList.get(1));
        assertEquals(Character.valueOf('a'), resultList.get(2));
    }

    @Test
    public void testReverseList_valid_input_with_many_characters() {
        List<Character> characters = Lists.newArrayList();
        characters.add('a');
        characters.add('b');
        characters.add('c');
        characters.add('d');
        characters.add('e');
        characters.add('f');
        List<Character> resultList = ListManipulator.reverseList(characters);
        assertEquals(11, resultList.size());
        assertEquals(Character.valueOf('a'), resultList.get(0));
        assertEquals(Character.valueOf('b'), resultList.get(1));
        assertEquals(Character.valueOf('c'), resultList.get(2));
        assertEquals(Character.valueOf('d'), resultList.get(3));
        assertEquals(Character.valueOf('e'), resultList.get(4));
        assertEquals(Character.valueOf('f'), resultList.get(5));
        assertEquals(Character.valueOf('e'), resultList.get(6));
        assertEquals(Character.valueOf('d'), resultList.get(7));
        assertEquals(Character.valueOf('c'), resultList.get(8));
        assertEquals(Character.valueOf('b'), resultList.get(9));
        assertEquals(Character.valueOf('a'), resultList.get(10));
    }

    @Test
    public void testDivideList() {
        List<Integer> input = Lists.newArrayList();
        input.add(3);
        input.add(1);
        input.add(4);
        input.add(5);
        input.add(9);
        input.add(2);
        input.add(6);
        input.add(8);
        input.add(7);
        List<Integer> expected = Lists.newArrayList();
        expected.add(2);
        expected.add(1);
        expected.add(3);
        expected.add(5);
        expected.add(9);
        expected.add(4);
        expected.add(6);
        expected.add(8);
        expected.add(7);
        List<Integer> actual = ListManipulator.divideList(input, 0);
        assertNotNull("The returned list should not be null.", actual);
        assertEquals("The size of the returned list is incorrect.", expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals("Incorrect value at index = " + i, expected.get(i), actual.get(i));
        }
    }

    @Test
    public void testDivideList_single_element() {
        List<Integer> input = Lists.newArrayList();
        input.add(10);
        List<Integer> actual = ListManipulator.divideList(input, 0);
        assertNotNull("Return value should not be null.", actual);
        assertEquals("Size is incorrect.", 1, actual.size());
    }

    @Test
    public void testDivideList_valid_list_invalid_position() {
        List<Integer> input = Lists.newArrayList();
        input.add(10);
        assertNull("Return value isn't null.", ListManipulator.divideList(input, 10));
    }

    @Test
    public void testDivideList_null_input() {
        assertNull("Returned value should have been null", ListManipulator.divideList(null, 12));
    }

    @Test
    public void testDivide_empty_input() {
        assertNull("Returned value should have been null", ListManipulator.divideList(new ArrayList<Integer>(), 12));
    }
}
