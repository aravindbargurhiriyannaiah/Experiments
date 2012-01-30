package com.funkyganesha;

import com.funkyganesha.exception.LightLotusException;
import org.apache.commons.lang.ArrayUtils;

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
}
