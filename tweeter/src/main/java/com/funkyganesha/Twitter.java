package com.funkyganesha;

import twitter4j.Tweet;
import twitter4j.TwitterException;

import java.util.List;

/**
 *
 */
public interface Twitter {
    boolean tweet(String message, String twitterId) throws TwitterException;

    List<Tweet> readTweet(String twitterId);


}
