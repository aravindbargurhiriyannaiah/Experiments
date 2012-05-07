package com.funkyganesha;

import org.apache.commons.lang.ArrayUtils;

import com.funkyganesha.exception.LightLotusException;
import com.google.common.base.Preconditions;

/**
 *
 */
public class Rotater {

    /**
     * @param array    input array that we want to rotate
     * @param rotateBy no of times we want to rotate the array
     * @return an array that has been rotated
     *         <br> Eg. {1, 2, 3, 4, 5} rotated 3 times is {3, 4, 5, 1, 2}
     * @throws LightLotusException
     */
    public static int[] rotate(int[] array, int rotateBy) throws LightLotusException {
        int[] resultArray = null;

        if (!ArrayUtils.isEmpty(array) && rotateBy > 0) {
            if (rotateBy > array.length) {
                rotateBy %= array.length;
            }
            resultArray = new int[array.length];
            int resultArrayIndex = 0;

            for (int i = array.length - rotateBy; i < array.length; i++) {
                resultArray[resultArrayIndex++] = array[i];
            }

            for (int i = 0; i < array.length - rotateBy; i++) {
                resultArray[resultArrayIndex++] = array[i];
            }
        } else {
            if (ArrayUtils.isEmpty(array)) {
                throw new LightLotusException("Input array is either empty or null");
            } else if (rotateBy < 0) {
                throw new LightLotusException("Cannot rotate by a negative number");
            }
        }
        return resultArray;
    }

    /**
     * The array sent as a parameter is formed by rotating an array that was sorted in ascending order 'n'  times, find n.
     * Eg.<ul>
     * <li>Initial array - 4, 5, 6, 7, 8 -- (A)</li>
     * <li>Right rotate the above array twice to get (C)</li>
     * <ul>
     * <li> Rotation 1 - 8, 4, 5, 6, 7 -- (B)</li>
     * <li>Rotation 2 - 7, 8, 4, 5, 6 -- (C)</li></ul>
     * <li>If input = C, output = 2. Because C is A, right rotated 2 times.</li>
     * </ul>
     *
     * @param array
     * @return the number of times the array has been right rotated to be in its current state.
     */
    public static int findRotations(int[] array) {
        Preconditions.checkArgument(ArrayUtils.isNotEmpty(array), "Input is either null or empty.");
        int result = 0;
        int i = 0;
        while (i < array.length - 1) {
            if (array[i] > array[i + 1]) {
                result = i + 1;
                break;
            }
            i += 1;
        }
        return result;
    }
}
