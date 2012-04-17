package com.funkyganesha;

import com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;

import java.util.Map;

public class PhoneNumberConverter {
    private static Map<String, Integer> lookUp = Maps.newHashMap();

    static {
        lookUp.put("zero", 0);
        lookUp.put("one", 1);
        lookUp.put("two", 2);
        lookUp.put("three", 3);
        lookUp.put("four", 4);
        lookUp.put("five", 5);
        lookUp.put("six", 6);
        lookUp.put("seven", 7);
        lookUp.put("eight", 8);
        lookUp.put("nine", 9);
    }

    public static int convertAlphaNumericPhoneNumbersToNumbersOnly(String str) {
        int result = -1;
        StringBuilder sb = new StringBuilder();
        if (StringUtils.isNotBlank(str)) {
            StringBuilder temp = new StringBuilder();
            for (char c : str.trim().toLowerCase().toCharArray()) {
                if (!Character.isSpaceChar(c)) {
                    if (Character.isDigit(c)) {
                        sb.append(c);
                    } else {
                        temp.append(c);
                        if (lookUp.containsKey(temp.toString())) {
                            sb.append(lookUp.get(temp.toString()));
                            temp.setLength(0);
                        }
                    }
                }
            }
            if (temp.length() == 0 || sb.length() > 0)
                result = Integer.parseInt(sb.toString());
        }
        return result;
    }
}
