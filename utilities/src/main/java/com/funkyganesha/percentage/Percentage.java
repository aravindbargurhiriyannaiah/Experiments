public class Percentage {
	    /**
     * @param choices
     * @return an ad network based on the associated percentage.
     * @throws Exception
     */
    public static AdNetwork randomlySelectAdNetwork(Map<AdNetwork, Double> choices) throws Exception {
        AdNetwork result = null;
        if (MapUtils.isNotEmpty(choices)) {
            List<AdNetworkPercentages> adNetworkPercentagesList = constructPercentageList(choices);
            if (CollectionUtils.isNotEmpty(adNetworkPercentagesList)) {
                double randomNumber = RandomUtils.nextDouble() * 100;
                double cumulative = 0.0;
                for (AdNetworkPercentages adNetworkPercentages : adNetworkPercentagesList) {
                    cumulative += adNetworkPercentages.getPercent();
                    if (randomNumber < cumulative) {
                        result = adNetworkPercentages.getAdNetwork();
                        break;
                    }
                }
            }
        }
        return result;
    }

    private static List<AdNetworkPercentages> constructPercentageList(Map<AdNetwork, Double> choices) throws Exception {
        List<AdNetworkPercentages> result = Lists.newArrayList();
        double sum = 0;
        for (AdNetwork adNetwork : choices.keySet()) {
            Double percent = choices.get(adNetwork);
            result.add(new AdNetworkPercentages(adNetwork, percent));
            sum += percent;
        }
        if (sum != 100.0) {
            if (log.isDebugEnabled()) {
                log.debug("Sum of all the ad network percentages should be 100. Currently it is " + sum);
            }
            result = null;
        }
        return result;
    }

    private static class AdNetworkPercentages {
        private AdNetwork adNetwork;
        private double percent;

        private AdNetworkPercentages(AdNetwork adNetwork, double percent) {
            this.adNetwork = adNetwork;
            this.percent = percent;
        }

        public AdNetwork getAdNetwork() {
            return adNetwork;
        }

        public double getPercent() {
            return percent;
        }

    }
}
