package com.funkyganesha;

import com.funkyganesha.exception.LightLotusException;
import com.google.common.collect.Maps;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;


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
     * @throws LightLotusException
     */
    public static String findAndRemoveDuplicateCharacters(String str) throws LightLotusException {
        String result;
        if (StringUtils.isNotBlank(str)) {
            StringBuilder stringBuilder = new StringBuilder();
            Set<Character> characters = new HashSet<Character>();
            for (char c : StringUtils.trim(str).toCharArray()) {
                if (characters.add(c)) {
                    stringBuilder.append(c);
                }
            }
            result = stringBuilder.toString();
        } else {
            throw new LightLotusException(str + " is invalid.");
        }
        return result;
    }

    /**
     * @param array containing strings which may/may not have duplicate characters
     * @return a string array with all the duplicate characters removed.
     * @see CharacterManipulator#findAndRemoveDuplicateCharacters(String)
     */
    public static String[] findAndRemoveDuplicateCharacters(String[] array) {
        String[] result = null;
        if (!ArrayUtils.isEmpty(array)) {
            result = new String[array.length];
            int resultIndex = 0;
            for (String input : array) {
                result[resultIndex++] = findAndRemoveDuplicateCharacters(input.trim());
            }
        } else {
            System.out.println("Input is invalid.");
        }
        return result;
    }

    public static Map.Entry<Character, Integer> findMaxOccurringCharacter(String str) {
        Map.Entry<Character, Integer> result = null;
        if (StringUtils.isNotBlank(str)) {
            Map<Character, Integer> map = Maps.newHashMap();
            int temp;
            for (char c : str.toCharArray()) {
                if (map.containsKey(c)) {
                    temp = map.get(c);
                    map.put(c, temp + 1);
                }   else {
                    map.put(c, 1);
                }
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


    public static void main(String[] Humble) {
        String[] input = {"aravind bargur hiriyannaiah", "deepika"};
        int index = 0;
        String[] output = CharacterManipulator.findAndRemoveDuplicateCharacters(input);
        for (String str : output) {
            System.out.println("Input = " + input[index++] + "\tAfter duplicate characters are removed = " + str);
        }
    }
}