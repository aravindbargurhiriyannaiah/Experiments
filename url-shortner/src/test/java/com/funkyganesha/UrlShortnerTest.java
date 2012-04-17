package com.funkyganesha;

import java.net.UnknownHostException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.funkyganesha.urlshortner.UrlShortnerService;
import com.funkyganesha.urlshortner.UrlShortnerServiceImpl;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

public class UrlShortnerTest {

    private UrlShortnerService urlShortnerService;

    @Before
    public void setup() {
        urlShortnerService = new UrlShortnerServiceImpl();
    }

    /**
     * This test needs the database to be working
     */
    @Ignore
    @Test
    public void testShortenUrl() {
        try {
            assertNotNull("The shorter URL should not be null", urlShortnerService.shortenUrl("http://funkyganesha.com"));
        } catch (UnknownHostException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @Ignore
    @Test
    public void testGetFullUrl() {
        try {
            String url = urlShortnerService.getFullUrl("wEkgV237Mhi2tuSE");
            assertNotNull("The returned URL should not be null", url);
        } catch (UnknownHostException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @Test
    public void testShortenUrl_with_null_input() throws UnknownHostException {
        assertNull(urlShortnerService.shortenUrl(null));
    }

    @Test
    public void testShortenUrl_with_empty_input() throws UnknownHostException {
        assertNull(urlShortnerService.shortenUrl(""));
    }
}
