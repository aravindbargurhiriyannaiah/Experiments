package com.funkyganesha.urlshortner.dao;

import com.funkyganesha.urlshortner.bean.UrlShortnerConfiguration;
import com.funkyganesha.urlshortner.domain.UrlDetails;
import com.funkyganesha.urlshortner.exception.UrlShortnerException;
import com.funkyganesha.urlshortner.util.MongodbConnector;
import com.funkyganesha.urlshortner.util.UrlShortnerConfigReader;
import com.google.common.base.Preconditions;
import com.mongodb.DB;
import com.mongodb.DBCollection;

import java.net.UnknownHostException;


public class UrlDetailsDaoImpl implements UrlDetailsDao {
    private static UrlShortnerConfiguration urlShortnerConfiguration;

    public boolean save(UrlDetails urlDetails) throws UrlShortnerException {
        Preconditions.checkArgument(urlDetails == null, new UrlShortnerException("Unable to work with null UrlDetails."));
        boolean result = false;
        UrlDetails urlDetailsFromDb = findByUrl(urlDetails.getLongUrl());
        if (urlDetailsFromDb == null) {
            try {
                DBCollection shortUrlsDbCollection = getMongoDb();

            } catch (UnknownHostException uhe) {
                throw new UrlShortnerException("Encountered problems while inserting into database.", uhe);
            }
        }
        return result;
    }

    public boolean delete(UrlDetails urlDetails) {
        return false;
    }

    public UrlDetails findByUrl(String url) {
        UrlDetails urlDetails = null;

        return urlDetails;
    }

    public UrlDetails findByShortUrl(String shortUrl) {
        UrlDetails urlDetails = null;
        return urlDetails;
    }

    private DBCollection getMongoDb() throws UnknownHostException {
        if (urlShortnerConfiguration == null) {
            urlShortnerConfiguration = UrlShortnerConfigReader.get();
        }
        DB db = MongodbConnector.getMongoDB(urlShortnerConfiguration);
        return db.getCollection(urlShortnerConfiguration.getCollectionName());
    }
}
