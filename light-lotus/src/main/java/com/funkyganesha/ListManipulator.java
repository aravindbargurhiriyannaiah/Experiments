package com.funkyganesha;

import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

public class ListManipulator {
    public static List<Character> reverseListAndCreatePalindrome(List<Character> characters) {
        if (CollectionUtils.isNotEmpty(characters)) {
            if (characters.size() == 1) {
                return characters;
            } else {
                for (int i = characters.size() - 2; i >= 0; i--) {
                    characters.add(characters.get(i));
                }
            }
        }
        return characters;
    }

    /**
     * This method is one pass of quick sort.
     * @param input
     * @param position
     * @return
     */
    public static List<Integer> divideList(List<Integer> input, int position) {
        List<Integer> result = null;
        if (CollectionUtils.isNotEmpty(input) && position <= input.size() ) {
            result = input;
            if(input.size() > 1) {
                int pivot = input.get(position);
                int i = 0;
                int begin = 0;
                int k = input.size() - 1;
                int end = input.size() - 1;
                while ((k - i) >= 1) {
                    while (pivot >= input.get(i) && i <= end && k > i) {
                        i++;
                    }
                    while (pivot <= input.get(k) && k >= begin && k >= i) {
                        k--;
                    }
                    if (k > i) {
                        Collections.swap(input, i, k);
                    }
                }
               Collections.swap(input, begin, k);
            }
        }
        return result;
    }
}
