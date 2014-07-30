package com.funkyganesha.service;

import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.TwitterException;

import java.util.List;

/**
 *
 */
public interface Twitter {
    boolean tweet(String message, String twitterId) throws TwitterException;

    /**
     *  Search within twitter
     *
     * @param searchString
     * @param date Eg.  "2011-01-01". Can be null.
     * @return
     * @throws TwitterException
     */
    List<Status> searchTwitter(String searchString, String date) throws TwitterException;

    ResponseList<Status> readTweets(String twitterId) throws TwitterException;

    /**
     * Read tweets of the given twitter Id using Twitter4J
     * @param twitterId
     * @param paging. Eg. new Paging(1, 100) will read the first 100 tweets, beginning from most recent.
     * @return
     * @throws TwitterException
     */
    ResponseList<Status> readTweets(String twitterId, Paging paging) throws TwitterException;
}
