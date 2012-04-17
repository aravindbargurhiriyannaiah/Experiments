package com.funkyganesha.percentage;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.math.RandomUtils;

import com.google.common.collect.Lists;

public class Percentage {
    /**
     * @param choices
     * @return an object based on the associated percentage.
     * @throws Exception
     */
    public static Object randomlySelectObject(Map<Object, Double> choices) throws Exception {
        Object result = null;
        if (MapUtils.isNotEmpty(choices)) {
            List<ObjectPercentages> objectPercentagesList = constructPercentageList(choices);
            if (CollectionUtils.isNotEmpty(objectPercentagesList)) {
                double randomNumber = RandomUtils.nextDouble() * 100;
                double cumulative = 0.0;
                for (ObjectPercentages objectPercentages : objectPercentagesList) {
                    cumulative += objectPercentages.getPercent();
                    if (randomNumber < cumulative) {
                        result = objectPercentages.getObject();
                        break;
                    }
                }
            }
        }
        return result;
    }

    private static List<ObjectPercentages> constructPercentageList(Map<Object, Double> choices) throws Exception {
        List<ObjectPercentages> result = Lists.newArrayList();
        double sum = 0;
        for (Object object : choices.keySet()) {
            Double percent = choices.get(object);
            result.add(new ObjectPercentages(object, percent));
            sum += percent;
        }
        if (sum != 100.0) {
            //Sum of all the ad network percentages should be 100.
        }
        return result;
    }

    private static class ObjectPercentages {
        private Object object;
        private double percent;

        private ObjectPercentages(Object object, double percent) {
            this.object = object;
            this.percent = percent;
        }

        public Object getObject() {
            return object;
        }

        public void setObject(Object object) {
            this.object = object;
        }

        public double getPercent() {
            return percent;
        }

        public void setPercent(double percent) {
            this.percent = percent;
        }
    }
}
