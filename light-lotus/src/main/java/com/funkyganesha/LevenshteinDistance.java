package com.funkyganesha;

import com.google.common.base.Preconditions;

public class LevenshteinDistance {
    public static int calculateLevenshteinDistance(String firstString, String secondString) {
        Preconditions.checkArgument((firstString != null), "The fist argument is null.");
        Preconditions.checkArgument((secondString != null), "The fist argument is null.");
        int result;
        if (firstString.length() == 0) {
            result = secondString.length();
        } else if (secondString.length() == 0) {
            result = firstString.length();
        } else {
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
                    cost = (firstString.charAt(i - 1) == secondString.charAt(j - 1)) ? 0 : 1;
                    array[i][j] = minimum(array[i - 1][j] + 1, array[i][j - 1] + 1, array[i - 1][j - 1] + cost);
                }
            }
            result = array[firstString.length()][secondString.length()];
        }
        return result;
    }

    private static int minimum(int first, int second, int third) {
        return Math.min(first, Math.min(second, third));
    }
}
