package com.funkyganesha.threads;

import java.util.Set;

import com.google.common.collect.Sets;

/**
 * Double checked locking - Bill Pugh
 * http://en.wikipedia.org/wiki/Singleton_pattern
 */
public class VowelSetSingleton {

    private VowelSetSingleton() {
    }

    private static class InstanceHolder {
        public static Set<Character> vowelSet = Sets.newHashSet('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
    }

    public static Set<Character> getSetOfVowels() {
        return InstanceHolder.vowelSet;
    }
}
