package com.funkyganesha.urlshortner.util;

import com.funkyganesha.urlshortner.bean.UrlShortnerConfiguration;
import com.funkyganesha.urlshortner.exception.UrlShortnerException;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.mongodb.DB;
import com.mongodb.Mongo;
import org.apache.commons.lang.StringUtils;

import java.net.UnknownHostException;
import java.util.Map;

public class MongodbConnector {
    private static Map<UrlShortnerConfiguration, DB> configurationDBMap = Maps.newHashMap();

    public static DB getMongoDB(UrlShortnerConfiguration urlShortnerConfiguration) throws UnknownHostException {
        validateParameter(urlShortnerConfiguration);
        DB result;
        if (configurationDBMap.containsKey(urlShortnerConfiguration)) {
            result = configurationDBMap.get(urlShortnerConfiguration);
        } else {
            Mongo mongo = new Mongo(urlShortnerConfiguration.getHostname(), urlShortnerConfiguration.getPort());
            result = mongo.getDB(urlShortnerConfiguration.getDatabase());
            if (urlShortnerConfiguration.getAuthenticationRequired()) {
                if (!result.authenticate(urlShortnerConfiguration.getUsername(), urlShortnerConfiguration.getPassword().toCharArray())) {
                    //Authentication failed.
                    result = null;
                }
            }
            if (result == null) {
                throw new UrlShortnerException("Cannot connect to the database if it is null. Authentication might have failed.");
            }
            configurationDBMap.put(urlShortnerConfiguration, result);
        }
        return result;
    }

    private static void validateParameter(UrlShortnerConfiguration urlShortnerConfiguration) {
        Preconditions.checkNotNull(urlShortnerConfiguration, "Configuration was null. ");
        Preconditions.checkArgument(StringUtils.isNotBlank(urlShortnerConfiguration.getDatabase()), "The databaseName was either null or empty.");
        Preconditions.checkArgument(StringUtils.isNotBlank(urlShortnerConfiguration.getHostname()), "The hostname was either null or empty.");
        Preconditions.checkArgument(StringUtils.isNotBlank(urlShortnerConfiguration.getCollectionName()), "The collection name was either null or empty.");
    }
}
