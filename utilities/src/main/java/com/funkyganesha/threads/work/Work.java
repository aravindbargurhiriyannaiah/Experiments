package com.funkyganesha.threads.work;

import java.util.Set;

import com.funkyganesha.threads.VowelSetSingleton;

/**
 *
 */
public class Work {
    private Set<Character> set = VowelSetSingleton.getSetOfVowels();
    private int noOfVowels;
    private String text;

    public Work(String text) {
        this.text = text;
    }

    public int countVowels() {
        noOfVowels = 0;
        for (char c : text.toCharArray()) {
            if (set.contains(c)) {
                noOfVowels++;
            }
        }
        return noOfVowels;
    }

    public int getNoOfVowels() {
        return noOfVowels;
    }

    public String getText() {
        return text;
    }
}


