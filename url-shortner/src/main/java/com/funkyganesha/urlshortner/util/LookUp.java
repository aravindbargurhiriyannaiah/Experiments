package com.funkyganesha.urlshortner.util;

import com.google.common.collect.Maps;

import javax.annotation.concurrent.ThreadSafe;
import java.util.Map;


/**
 * Based on the Initialization-on-demand holder idiom
 */
@ThreadSafe
public class LookUp {
    private LookUp() {
    }

    private static class LazyLookUp {
        public static Map<Long, Character> lookUp = constructMap();

        private static Map<Long, Character> constructMap() {
            Map<Long, Character> lookUp = Maps.newHashMap();
            char c;
            long counter = 0;
            //a to z
            for (int i = 97; i <= (97 + 26); i++) {
                c = (char) i;
                lookUp.put(counter++, c);
            }
            //A to Z
            for (int i = 65; i <= (65 + 26); i++) {
                c = (char) i;
                lookUp.put(counter++, c);
            }
            //0 - 9
            for (int i = 48; i <= 57; i++) {
                c = (char) i;
                lookUp.put(counter++, c);
            }
            return lookUp;
        }
    }


    public static char get (long key) {
        return LazyLookUp.lookUp.get(key);
    }
}
