package com.funkyganesha;


import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Tweet;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class TwitterImpl implements Twitter {
    private static final Logger log = LoggerFactory.getLogger(TwitterImpl.class);
    public static final int NUMBER_OF_TWEETS_PER_PAGE = 100;


    public boolean tweet(String message, String twitterId) throws TwitterException {
        boolean result = false;
        twitter4j.Twitter twitter = new TwitterFactory().getInstance();
        Status status = twitter.updateStatus("posted from my tweeter");
        result = StringUtils.isNotBlank(status.getText());
        return result;
    }

    public List<Tweet> readTweet(String twitterId) {
        List<Tweet> result = null;
        if (StringUtils.isNotBlank(twitterId)) {
            log.debug("Starting to read tweets from twitterId: " + twitterId);
            twitter4j.Twitter twitter = new TwitterFactory().getInstance();
            Query query = new Query("from:" + twitterId);
            query.setRpp(NUMBER_OF_TWEETS_PER_PAGE);
            try {
                QueryResult search = twitter.search(query);
                if (search != null) {
                    result = search.getTweets();
                }
            } catch (TwitterException e) {
                log.error("Something went wrong while accessing the twitter account of " + twitterId, e);
            }
        }

        return result;
    }
}
