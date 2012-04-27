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
    public static <K> K selectRandomly(Map<K, Double> choices) throws Exception {
        K result = null;
        if (MapUtils.isNotEmpty(choices)) {
            List<ObjectPercentages> objectPercentagesList = constructPercentageList(choices);
            if (CollectionUtils.isNotEmpty(objectPercentagesList)) {
                double randomNumber = RandomUtils.nextDouble() * 100;
                double cumulative = 0.0;
                for (ObjectPercentages objectPercentages : objectPercentagesList) {
                    cumulative += objectPercentages.getPercent();
                    if (randomNumber < cumulative) {
                        result = (K) objectPercentages.getK();
                        break;
                    }
                }
            }
        }
        return result;
    }

    private static <K> List<ObjectPercentages> constructPercentageList(Map<K, Double> choices) throws Exception {
        List<ObjectPercentages> result = Lists.newArrayList();
        double sum = 0;
        for (K k : choices.keySet()) {
            Double percent = choices.get(k);
            result.add(new ObjectPercentages(k, percent));
            sum += percent;
        }
        if (sum != 100.0) {
            //Sum of all the ad network percentages should be 100.
        }
        return result;
    }

    private static class ObjectPercentages<K> {
        private K k;
        private double percent;

        public ObjectPercentages(K k, double percent) {
            this.k = k;
            this.percent = percent;
        }

        public K getK() {
            return k;
        }

        public void setK(K k) {
            this.k = k;
        }

        public double getPercent() {
            return percent;
        }

        public void setPercent(double percent) {
            this.percent = percent;
        }
    }
}
