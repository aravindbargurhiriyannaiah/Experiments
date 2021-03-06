package com.funkyganesha.urlshortner;

import com.funkyganesha.urlshortner.bean.UrlShortnerConfiguration;
import com.funkyganesha.urlshortner.exception.UrlShortnerException;
import com.funkyganesha.urlshortner.util.UrlShortnerConfigReader;
import com.funkyganesha.urlshortner.util.LookUp;
import com.funkyganesha.urlshortner.util.MongodbConnector;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import org.apache.commons.lang.StringUtils;
import org.bson.types.ObjectId;

import java.math.BigInteger;
import java.net.UnknownHostException;

public class UrlShortner {
    private static UrlShortnerConfiguration urlShortnerConfiguration;
    public static final String KEY_URL = "url";
    public static final String KEY_SHORTURL = "shorturl";
    public static final String BASE_62 = "62";

    public static String shortenUrl(String url) throws UnknownHostException {
        String result = null;
        if (StringUtils.isNotBlank(url)) {
            DBObject dbObject = load(KEY_URL, url);
            if (dbObject == null) {
                ObjectId objectId = insertIntoDatabase(url, null, null);
                if (objectId != null) {
                    BigInteger bigInteger = new BigInteger(objectId.toString(), 16);
                    result = computeHash(bigInteger);
                    insertIntoDatabase(url, result, objectId);
                }
            } else {
                result = (String) dbObject.get(KEY_SHORTURL);
            }
        }
        return result;
    }

    public static String getFullUrl(String shorterString) throws UnknownHostException {
        String result = null;
        if (StringUtils.isNotBlank(shorterString)) {
            DBObject dbObject = load(KEY_SHORTURL, shorterString);
            if (dbObject != null) {
                result = (String) dbObject.get(KEY_URL);
            }
        }
        return result;
    }

    private static String computeHash(BigInteger bigInteger) {
        StringBuilder sb = new StringBuilder();
        BigInteger mod = new BigInteger(BASE_62);
        BigInteger tempBigInteger;
        while (!bigInteger.equals(BigInteger.ZERO)) {
            tempBigInteger = bigInteger.mod(mod);
            sb.append(LookUp.get(tempBigInteger.longValue()));
            bigInteger = bigInteger.divide(mod);
        }
        return sb.toString();
    }

    private static ObjectId insertIntoDatabase(String url, String shorterUrl, ObjectId objectId) throws UrlShortnerException {
        ObjectId result = null;
        try {
            DBCollection shortUrlsDbCollection = getMongoDb();
            if (objectId != null) {
                DBObject existingDBObject = shortUrlsDbCollection.findOne(objectId);
                if (existingDBObject != null) {
                    //The URl has been stored. Update the row with the shortened URL.
                    DBObject updatedDBObject = constructRowToBeInserted(url, shorterUrl);
                    shortUrlsDbCollection.update(existingDBObject, updatedDBObject, false, false);
                }
            } else {
                //This URL does not exist in the database. It is a first time insertion.
                DBObject doc = constructRowToBeInserted(url, null);
                shortUrlsDbCollection.insert(doc);
                result = (ObjectId) doc.get("_id");
            }
        } catch (UnknownHostException e) {
            throw new UrlShortnerException("Could not obtain the mongo db. ", e);
        }
        return result;
    }

    private static DBCollection getMongoDb() throws UnknownHostException {
        if (urlShortnerConfiguration == null) {
            urlShortnerConfiguration = UrlShortnerConfigReader.get();
        }
        DB db = MongodbConnector.getMongoDB(urlShortnerConfiguration);
        return db.getCollection(urlShortnerConfiguration.getCollectionName());
    }

    /**
     * Loads from the database any key, value pair
     *
     * @param key
     * @param url
     * @return
     * @throws UnknownHostException
     */
    private static DBObject load(String key, String url) throws UnknownHostException {
        DBCollection dbCollection = getMongoDb();
        DBObject searchDBObject = new BasicDBObject();
        searchDBObject.put(key, url);
        return dbCollection.findOne(searchDBObject);
    }

    private static DBObject constructRowToBeInserted(String url, String shorterUrl) {
        BasicDBObject row = new BasicDBObject();
        row.put(KEY_URL, url);
        if (StringUtils.isNotBlank(shorterUrl)) {
            row.put(KEY_SHORTURL, shorterUrl);
        }
        return row;
    }
}
