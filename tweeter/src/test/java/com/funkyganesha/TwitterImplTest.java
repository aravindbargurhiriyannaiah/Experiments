package com.funkyganesha;

import com.funkyganesha.service.Twitter;
import com.funkyganesha.service.TwitterImpl;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.*;

import java.util.List;

import static junit.framework.Assert.*;

/**
 *
 */
public class TwitterImplTest {
    private static final String SAMPLE_TWITTER_ACCOUNT = "martinfowler";
    private static final Logger log = LoggerFactory.getLogger(TwitterImplTest.class);
    private static final String SAMPLE_SEARCH_STRING = "Java";
    private Twitter twitter = new TwitterImpl();

    @Test
    public void testReadTweetWithPaging() throws TwitterException {
        ResponseList<Status> responseList = twitter.readTweets(SAMPLE_TWITTER_ACCOUNT, new Paging(1, 100));
        assertNotNull("Status of " + SAMPLE_TWITTER_ACCOUNT + " should not be null.", responseList);
        assertEquals("No of responses obtained was incorrect.", 100, responseList.size());
    }

    @Test
    public void testReadTweetWithoutPaging() throws TwitterException {
        ResponseList<Status> responseList = twitter.readTweets(SAMPLE_TWITTER_ACCOUNT);
        assertNotNull("Status of " + SAMPLE_TWITTER_ACCOUNT + " should not be null.", responseList);
        assertEquals("No of responses obtained was incorrect.", 20, responseList.size());
    }

    @Test
    public void testReadTweetWithPagingAndNullTwitterId() throws TwitterException {
        assertNull(twitter.readTweets(null, new Paging(1, 100)));
    }

    @Test
    public void testReadTweetFromNullTwitterId() throws TwitterException {
        assertNull(twitter.readTweets(null));
    }

    @Test
    public void testReadTweetFromEmptyTwitterId() throws TwitterException {
        assertNull(twitter.readTweets(""));
    }

    @Test
    public void testSearchTwitter() throws Exception {
        List<Status> result = twitter.searchTwitter(SAMPLE_SEARCH_STRING, null);
        assertNotNull("Should not have been null", result);
    }
}
