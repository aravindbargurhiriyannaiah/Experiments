package com.funkyganesha;

import twitter4j.Tweet;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static junit.framework.Assert.assertNotNull;

/**
 *
 */
public class TwitterImplTest {
    private TwitterImpl twitterImpl;
    private static final Logger log = LoggerFactory.getLogger(TwitterImplTest.class);


    @Before
    public void setUp() throws Exception {
        twitterImpl = new TwitterImpl();
    }

    

    @Test
    public void testReadTweet() throws Exception {
        List<Tweet> result = twitterImpl.readTweet("martinfowler");
        assertNotNull("Should not have been null", result);
        log.debug("No of tweets found: " + result.size());
        for (Tweet tweet : result) {
            log.debug(tweet.getText());
        }

    }
}
