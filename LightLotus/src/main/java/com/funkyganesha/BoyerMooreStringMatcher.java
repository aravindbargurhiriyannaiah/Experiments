package com.funkyganesha;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;

import java.util.Map;

public class BoyerMooreStringMatcher {
    public static boolean matchIgnoreCase(String text, String pattern) {
        boolean result = false;
        if (areArgumentsValid(text, pattern)) {

            Map<Character, Integer> characterJumpTable = Maps.newHashMap();
            char[] patternArray = pattern.toCharArray();
            int jumpIndex = 0;
            int patternLength = patternArray.length - 1;
            for (int i = patternLength; i >= 0; i--) {
                characterJumpTable.put(patternArray[i], jumpIndex++);
            }

            jumpIndex = patternLength;
            while (text.length() > jumpIndex) {
                if (text.charAt(jumpIndex) == patternArray[patternLength]) {
                    int matched = 1;
                    while (patternLength >= 0 && text.charAt(jumpIndex) == patternArray[patternLength]) {
                        jumpIndex--;
                        patternLength--;
                        matched++;
                    }
                    if (patternLength == -1) {
                        result = true;
                        break;
                    } else {
                        jumpIndex += matched + patternLength;
                        patternLength = patternArray.length - 1;
                    }
                } else if (characterJumpTable.containsKey(text.charAt(jumpIndex))) {
                    jumpIndex += characterJumpTable.get(text.charAt(jumpIndex));
                } else {
                    jumpIndex += patternLength + 1;
                }
            }
        }
        return result;
    }

    private static boolean areArgumentsValid(String text, String pattern) {
        boolean result;
        try {
            Preconditions.checkNotNull(text, "Search string cannot be null.");
            Preconditions.checkNotNull(pattern, "Pattern cannot be null.");
            Preconditions.checkArgument(text.length() > pattern.length(), "Pattern length is greater than search string");
            result = true;
        } catch (IllegalArgumentException e) {
            result = false;
        } catch (NullPointerException e) {
            result = false;
        }
        return result;
    }
}
