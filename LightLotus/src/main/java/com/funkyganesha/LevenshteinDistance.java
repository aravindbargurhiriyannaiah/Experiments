package com.funkyganesha;

import com.funkyganesha.exception.LightLotusException;
import org.apache.commons.lang.StringUtils;

public class LevenshteinDistance {
    public static int calculateLevenshteinDistance(String firstString, String secondString) {
        int result = -1;
        if (StringUtils.isNotBlank(firstString) && StringUtils.isNotBlank(secondString)) {
            int[][] array = new int[firstString.length() + 1][secondString.length() + 1];
            for (int i = 0; i <= firstString.length(); i++) {
                array[i][0] = i;
            }
            for (int i = 0; i <= secondString.length(); i++) {
                array[0][i] = i;
            }
            int cost;
            for (int i = 1; i <= firstString.length(); i++) {
                for (int j = 1; j <= secondString.length(); j++) {
                    if (firstString.charAt(i - 1) == secondString.charAt(j - 1)) {
                        cost = 0;
                    } else {
                        cost = 1;
                    }
                    array[i][j] = minimum(array[i - 1][j] + 1, array[i][j - 1] + 1, array[i - 1][j - 1] + cost);
                }
            }
            result = array[firstString.length()][secondString.length()];

        } else {
            if (firstString == null || secondString == null) {
                throw new LightLotusException("Invalid input. Cannot compute Levenshtein distance. FirstString = " + firstString + " and secondString = " + secondString);
            }
            if (firstString.length() == 0) {
                result = secondString.length();
            } else if (secondString.length() == 0) {
                result = firstString.length();
            }
        }
        return result;
    }

    private static int minimum(int first, int second, int third) {
        return Math.min(first, Math.min(second, third));
    }

    private static void printArray(int[][] array) {
        int rows = array.length;
        int columns = array[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }
}
