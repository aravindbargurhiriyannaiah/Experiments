public class PercentageTest {
	   public static final int NO_OF_TIMES = 100000;


    @Test
    public void testRandomlySelectAdNetwork() throws Exception {
        Map<AdNetwork, Double> adNetworkChoices = populateTestAdNetworkPercentage();
        Map<AdNetwork, Double> adNetworkCounts = Maps.newHashMap();
        for (int i = 0; i < NO_OF_TIMES; i++) {
            AdNetwork adNetwork = AdRequestUtils.randomlySelectAdNetwork(adNetworkChoices);
            addIntoMap(adNetwork, adNetworkCounts);
        }
        Map<AdNetwork, Double> result = computePercentages(adNetworkCounts);
        verify(result, adNetworkChoices);
    }

    private void verify(Map<AdNetwork, Double> result, Map<AdNetwork, Double> adNetworkChoices) {
        if (log.isDebugEnabled()) {
            log.debug("No of times the random selection is run [" + NO_OF_TIMES + "] ");
        }

        assertNotNull("Result of computation should not be null", result);
        assertEquals("Incorrect size", result.size(), adNetworkChoices.size());
        Set<AdNetwork> adNetworks = adNetworkChoices.keySet();
        for (AdNetwork adNetwork : adNetworks) {
            Double expected = adNetworkChoices.get(adNetwork);
            Double actual = result.get(adNetwork);
            if (log.isDebugEnabled()) {
                log.debug("expected [" + expected + "], actual [" + actual + "]");
            }
            assertEquals("Incorrect percentage", expected, actual, 2.0);
        }
    }

    private static Map<AdNetwork, Double> populateTestAdNetworkPercentage() {
        Map<AdNetwork, Double> adNetworkDoubleMap = Maps.newHashMap();
        adNetworkDoubleMap.put(createTestAdNetwork("Superpages"), 10.0);
        adNetworkDoubleMap.put(createTestAdNetwork("Marchex"), 30.0);
        adNetworkDoubleMap.put(createTestAdNetwork("xAd"), 15.0);
        adNetworkDoubleMap.put(createTestAdNetwork("Double click"), 25.0);
        adNetworkDoubleMap.put(createTestAdNetwork("City Grid"), 20.0);
        return adNetworkDoubleMap;
    }

    private static void addIntoMap(AdNetwork adNetwork, Map<AdNetwork, Double> adNetworkCounts) {
        Double count;
        count = adNetworkCounts.get(adNetwork);
        if (count == null) {
            count = 1.0;
        } else {
            count += 1;
        }
        adNetworkCounts.put(adNetwork, count);
    }

    public static AdNetwork createTestAdNetwork(String name) {
        final int random = 20;
        AdNetwork adNetwork = new AdNetwork();
        adNetwork.setName(name);
        adNetwork.setId(RandomUtils.nextInt(random));
        adNetwork.setIsActive(true);
        adNetwork.setServiceKey(RandomStringUtils.randomAlphanumeric(random));
        adNetwork.setUrlBase(RandomStringUtils.randomAlphanumeric(random));
        adNetwork.setAccountNumber(RandomStringUtils.randomAlphanumeric(random));
        adNetwork.setTimeout(RandomUtils.nextInt(random));
        return adNetwork;
    }

    private static Map<AdNetwork, Double> computePercentages(Map<AdNetwork, Double> adNetworkCounts) {
        Map<AdNetwork, Double> result = Maps.newHashMap();
        double percent = -1;
        for (AdNetwork adNetwork : adNetworkCounts.keySet()) {
            Double count = adNetworkCounts.get(adNetwork);
            if (count != null) {
                percent = (count / NO_OF_TIMES) * 100;
            }
            result.put(adNetwork, percent);
        }
        return result;
    }
}
