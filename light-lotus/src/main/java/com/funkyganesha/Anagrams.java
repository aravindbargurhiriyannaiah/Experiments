package com.funkyganesha;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.math.RandomUtils;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;


/**
 *
 */
public class Anagrams {
    private static Map<Character, Integer> lookUp = Maps.newHashMap();

    static {
        //Load the entire ascii table into the map
        for (int i = 32; i < 127; i++) {
            lookUp.put((char) i, i);
        }
    }

    public static final List<String> INPUT = Arrays.asList("gOOd", "aravind", "Nob<el", "dogO", "<leboN", "a;rav1nd", "aravn1d;");

    public static List<List<String>> findAnagramsIgnoreCase(List<String> anagrams) throws Exception {
        return findAnagrams(anagrams, true);
    }

    public static List<List<String>> findAnagrams(List<String> anagrams) throws Exception {
        return findAnagrams(anagrams, false);
    }

    private List<String> generateAnagrams(List<String> words) {
        Preconditions.checkArgument(CollectionUtils.isNotEmpty(words), "Input is either null or empty.");

        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            stringBuilder.append(word);
        }
        List<Character> characters = new ArrayList<Character>();
        for (char c : words.toString().toCharArray()) {
            characters.add(c);
        }
        Collections.shuffle(characters);
        int index = 0;
        stringBuilder.setLength(0);
        List<String> anagrams = new ArrayList<String>();
        for (char c : characters) {
            stringBuilder.append(c);
            if (RandomUtils.nextInt(characters.size() / 4) == index) {
                anagrams.add(stringBuilder.toString());
                stringBuilder.setLength(0);
            }
        }
        anagrams.add(stringBuilder.toString());
        return anagrams;
    }

    private static List<List<String>> findAnagrams(List<String> anagrams, boolean ignoreCase) throws Exception {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
        for (String string : anagrams) {
            int hashCode;
            hashCode = (ignoreCase) ? calculateHashCode(string.toLowerCase()) : calculateHashCode(string);
            List<String> strings = map.get(hashCode);
            if (CollectionUtils.isEmpty(strings)) {
                strings = new ArrayList<String>();
                map.put(hashCode, strings);
            }
            strings.add(string);
        }
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            List<String> foundAnagrams = entry.getValue();
            if (foundAnagrams.size() > 1) {
                result.add(foundAnagrams);
            }
        }
        return result;
    }

    public static void main(String[] Preclude) throws Exception {
        Anagrams anagrams = new Anagrams();
        System.out.println(anagrams.generateAnagrams(Arrays.asList("aravind", "is", "programming ")));
    }

    private static int calculateHashCode(String str) throws Exception {
        int hashCode = 0;
        for (char c : str.toCharArray()) {
            hashCode += lookUp.get(c);
        }
        return hashCode;
    }
}
