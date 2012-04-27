package com.funkyganesha.percentage;

import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.Maps;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PercentageTest {
    public static final int NO_OF_TIMES = 100000;

    @Test
    public void testRandomlySelectObject() throws Exception {
        Map<Object, Double> objectChoices = populateTestObjectPercentage();
        Map<Object, Double> objectCounts = Maps.newHashMap();
        for (int i = 0; i < NO_OF_TIMES; i++) {
            Object result = Percentage.selectRandomly(objectChoices);
            Map<String, Double> m = Maps.newHashMap();
            Percentage.selectRandomly(m);
            addIntoMap(result, objectCounts);
        }
        Map<Object, Double> result = computePercentages(objectCounts);
        verify(result, objectChoices);
    }

    private void verify(Map<Object, Double> result, Map<Object, Double> objectChoices) {
        assertNotNull("Result of computation should not be null", result);
        assertEquals("Incorrect size", result.size(), objectChoices.size());
        Set<Object> objects = objectChoices.keySet();
        for (Object object : objects) {
            Double expected = objectChoices.get(object);
            Double actual = result.get(object);
            assertEquals("Incorrect percentage", expected, actual, 2.0);
        }
    }

    private static Map<Object, Double> populateTestObjectPercentage() {
        Map<Object, Double> objectDoubleMap = Maps.newHashMap();
        objectDoubleMap.put(new Object(), 10.0);
        objectDoubleMap.put(new Object(), 30.0);
        objectDoubleMap.put(new Object(), 15.0);
        objectDoubleMap.put(new Object(), 25.0);
        objectDoubleMap.put(new Object(), 20.0);
        return objectDoubleMap;
    }

    private static void addIntoMap(Object object, Map<Object, Double> objectMap) {
        Double count;
        count = objectMap.get(object);
        if (count == null) {
            count = 1.0;
        } else {
            count += 1;
        }
        objectMap.put(object, count);
    }

    private static Map<Object, Double> computePercentages(Map<Object, Double> objectCounts) {
        Map<Object, Double> result = Maps.newHashMap();
        double percent = -1;
        for (Object object : objectCounts.keySet()) {
            Double count = objectCounts.get(object);
            if (count != null) {
                percent = (count / NO_OF_TIMES) * 100;
            }
            result.put(object, percent);
        }
        return result;
    }
}
