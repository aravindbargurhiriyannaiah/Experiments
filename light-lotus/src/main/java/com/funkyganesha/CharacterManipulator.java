package com.funkyganesha;

import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;


/**
 * ;
 */
public class CharacterManipulator {

    /**
     * Find and remove only duplicate characters - the second occurrence of every character is removed.
     * <br>Eg. input = aravind, output = arvind
     *
     * @param str input string which may/may not contain duplicate characters
     * @return a string which has no duplicate characters
     */
    public static String findAndRemoveDuplicateCharacters(String str) {
        Preconditions.checkArgument(StringUtils.isNotBlank(str), "The input is either null or empty.");
        StringBuilder stringBuilder = new StringBuilder();
        Set<Character> characters = Sets.newHashSet();
        for (char c : StringUtils.trim(str).toCharArray()) {
            if (characters.add(c)) {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    /**
     * @param array containing strings which may/may not have duplicate characters
     * @return a string array with all the duplicate characters removed.
     * @see CharacterManipulator#findAndRemoveDuplicateCharacters(String)
     */
    public static String[] findAndRemoveDuplicateCharacters(String[] array) {
        Preconditions.checkArgument(ArrayUtils.isNotEmpty(array), "Input is either null or empty");
        String[] result = new String[array.length];
        int resultIndex = 0;
        for (String input : array) {
            result[resultIndex++] = findAndRemoveDuplicateCharacters(input.trim());
        }
        return result;
    }

    public static Map.Entry<Character, Integer> findMaxOccurringCharacter(String str) {
        Map.Entry<Character, Integer> result = null;
        if (StringUtils.isNotBlank(str)) {
            Map<Character, Integer> map = Maps.newHashMap();
            Integer temp;
            for (char c : str.toCharArray()) {
                temp = map.get(c);
                if (temp == null) {
                    temp = 0;
                }
                map.put(c, temp + 1);
            }
            temp = -1;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() > temp) {
                    result = entry;
                    temp = entry.getValue();
                }
            }
        }
        return result;
    }
}