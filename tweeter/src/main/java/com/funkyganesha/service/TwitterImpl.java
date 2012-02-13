package com.funkyganesha.service;


import twitter4j.Paging;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Tweet;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class TwitterImpl implements Twitter {
    private static final Logger log = LoggerFactory.getLogger(TwitterImpl.class);
    public static final int NUMBER_PER_PAGE = 100;
    private twitter4j.Twitter twitter = new TwitterFactory().getInstance();

    public boolean tweet(String message, String twitterId) throws TwitterException {
        boolean result;
        Status status = twitter.updateStatus("test: posted from my tweeter" + new Date());
        result = StringUtils.isNotBlank(status.getText());
        return result;
    }

    public ResponseList<Status> readTweets(String twitterId) throws TwitterException {
        return readTweets(twitterId, null);
    }

    public ResponseList<Status> readTweets(String twitterId, Paging paging) throws TwitterException {
        ResponseList<Status> userTimeline = null;
        if (StringUtils.isNotBlank(twitterId)) {
            if (log.isDebugEnabled()) {
                log.debug("Reading tweets by[" + twitterId + "] ");
            }
            if (paging != null) {
                userTimeline = twitter.getUserTimeline(twitterId, paging);
            } else {
                userTimeline = twitter.getUserTimeline(twitterId);
            }
            if (log.isDebugEnabled()) {
                log.debug("No of status found [" + userTimeline.size() + "] ");
            }
        } else {
            log.error("Cannot continue; invalid twitterId [" + twitterId + "] ");
        }
        return userTimeline;
    }

    public List<Tweet> searchTwitter(String searchString, String date) throws TwitterException {
        List<Tweet> result = null;
        if (StringUtils.isNotBlank(searchString)) {
            Query query = new Query(searchString);
            query.setRpp(NUMBER_PER_PAGE);
            if (StringUtils.isNotBlank(date)) {
                query.setSince(date);
            }
            try {
                QueryResult search = twitter.search(query);
                if (search != null) {
                    result = search.getTweets();
                    if (log.isDebugEnabled()) {
                        log.debug("No of search results found [" + result.size() + "]");
                    }
                }
            } catch (TwitterException e) {
                log.error("Something went wrong while searching for " + searchString, e);
            }
        }
        return result;
    }
}
