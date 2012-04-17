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
     * This test needs the database to be working - this is bad practice, will be mocking it shortly.
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
//    @Test
//    public void testComputeShorterHash() {
//        assertEquals("bc", UrlShortne.longValue()r.computeShorterHash(125));
//    }
//
//    @Test
//    public void testComputeShorterHash_with_negative_number() {
//        assertNull("Should have been null as the input is a negative number", UrlShortnerServiceImpl.computeShorterHash(-1));
//    }
//
//    @Test  (expected = NullPointerException.class)
//    public void testInsertIntoDatabase_with_null_configuration() {
//        mockStatic(UrlShortnerConfigReader.class);
//        expect(UrlShortnerConfigReader.get()).andReturn(null);
//        replayAll();
//        assertNull(UrlShortnerServiceImpl.insertIntoDatabase("http://funkyganesha.com"));
//        verifyAll();
//    }
//
//    @Test
//    public void testInsertIntoDatabase_with_valid_configuration() {
//        assertNotNull(UrlShortnerServiceImpl.insertIntoDatabase("http://funkyganesha.com"));
//    }
//
//    private UrlShortnerConfiguration constructLightLotusConfiguration() {
//
//        return null;
//    }
//
//    @Test
//    public void testInsertIntoDatabase_with_null_input() {
//        assertNull(UrlShortnerServiceImpl.insertIntoDatabase(null));
//    }
//
//
//    @Test
//    public void testInsertIntoDatabase_with_empty_input() {
//        assertNull(UrlShortnerServiceImpl.insertIntoDatabase(""));
//    }
}
