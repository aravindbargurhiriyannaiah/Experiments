package com.funkyganesha;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;

import static junit.framework.Assert.assertEquals;

public class PhoneNumberConverterTest {

    @Test
    public void testTranslateAlphaNumericPhoneNumbersToNumbersOnly_valid_cases() {
        Map<String, Integer> testMap = Maps.newHashMap();
        testMap.put("8", 8);
        testMap.put(" 8", 8);
        testMap.put("8 ", 8);
        testMap.put(" 8 ", 8);
        testMap.put("908", 908);
        testMap.put(" 6 5 4 ", 654);
        testMap.put("One", 1);
        testMap.put(" One", 1);
        testMap.put("O ne", 1);
        testMap.put("One ", 1);
        testMap.put(" One ", 1);
        testMap.put(" Two Three Four ", 234);
        testMap.put("8TwoNine", 829);
        testMap.put("OneEightZeroZero", 1800);
        testMap.put("Ninuigh", -1);
        testMap.put("NinEigh", 9);
        testMap.put("", -1);
        testMap.put(null, -1);
        testMap.put("(*&^^$#8idjd", 8);
        testMap.put("6(*&9^^$#", 69);
        for (Map.Entry<String, Integer> entry : testMap.entrySet()) {
            assertEquals(entry.getValue().intValue(), PhoneNumberConverter.convertAlphaNumericPhoneNumbersToNumbersOnly(entry.getKey()));
        }
    }
}
