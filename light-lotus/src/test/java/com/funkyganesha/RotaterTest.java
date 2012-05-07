package com.funkyganesha;

import org.junit.Before;
import org.junit.Test;

import com.funkyganesha.exception.LightLotusException;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;

import static junit.framework.Assert.assertEquals;


public class RotaterTest {

    public static final String ARRAY_HAS_BEEN_INCORRECTLY_ROTATED = "Array has been incorrectly rotated.";
    int[] inputArray;
    int rotateBy;

    @Before
    public void setUp() throws Exception {
        inputArray = new int[]{1, 2, 3, 4, 5};
    }

    @Test(expected = LightLotusException.class)
    public void testRotate_Null_Input_array() {
        Rotater.rotate(null, rotateBy);
    }

    @Test(expected = LightLotusException.class)
    public void testRotate_ValidInput_negative_rotateBy() {
        rotateBy = -12;
        Rotater.rotate(inputArray, rotateBy);
    }

    @Test
    public void testRotate_validInput_valid_rotateBy() {
        rotateBy = 3;
        int[] rotatedArray = Rotater.rotate(inputArray, rotateBy);
        assertEquals(ARRAY_HAS_BEEN_INCORRECTLY_ROTATED, 3, rotatedArray[0]);
        assertEquals(ARRAY_HAS_BEEN_INCORRECTLY_ROTATED, 4, rotatedArray[1]);
        assertEquals(ARRAY_HAS_BEEN_INCORRECTLY_ROTATED, 5, rotatedArray[2]);
        assertEquals(ARRAY_HAS_BEEN_INCORRECTLY_ROTATED, 1, rotatedArray[3]);
        assertEquals(ARRAY_HAS_BEEN_INCORRECTLY_ROTATED, 2, rotatedArray[4]);
    }

    @Test
    public void testRotate_validInput_valid_rotateByGreaterThanInputArraySize() {
        rotateBy = 7;
        int[] rotatedArray = Rotater.rotate(inputArray, rotateBy);
        assertEquals(ARRAY_HAS_BEEN_INCORRECTLY_ROTATED, 4, rotatedArray[0]);
        assertEquals(ARRAY_HAS_BEEN_INCORRECTLY_ROTATED, 5, rotatedArray[1]);
        assertEquals(ARRAY_HAS_BEEN_INCORRECTLY_ROTATED, 1, rotatedArray[2]);
        assertEquals(ARRAY_HAS_BEEN_INCORRECTLY_ROTATED, 2, rotatedArray[3]);
        assertEquals(ARRAY_HAS_BEEN_INCORRECTLY_ROTATED, 3, rotatedArray[4]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindNumberOfRotationsWithNullArray() {
        Rotater.findRotations(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindNumberOfRotationsWithEmpthArray() {
        Rotater.findRotations(new int[]{});
    }

    @Test
    public void testFindNumberOfRotations() {
        int[] array = Ints.toArray(Lists.<Integer>newArrayList(7, 8, 4, 5, 6));
        int rotations = Rotater.findRotations(array);
        assertEquals("Invalid number of rotations round", 2, rotations);
    }

    @Test
    public void testFindNumberOfRotationsInSortedArray() {
        int[] array = Ints.toArray(Lists.<Integer>newArrayList(4, 5, 6));
        int rotations = Rotater.findRotations(array);
        assertEquals("Invalid number of rotations", 0, rotations);
    }

    @Test
    public void testFindNumberOfRotationsWithLastIndex() {
        int[] array = Ints.toArray(Lists.<Integer>newArrayList(7, 8, 9, 4));
        int rotations = Rotater.findRotations(array);
        assertEquals("Invalid number of rotations round", 3, rotations);
    }
}
