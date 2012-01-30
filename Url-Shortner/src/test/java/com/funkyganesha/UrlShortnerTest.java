package com.funkyganesha;

import com.funkyganesha.urlshortner.UrlShortnerServiceImpl;
import org.junit.Ignore;
import org.junit.Test;

import java.net.UnknownHostException;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;




public class UrlShortnerTest {

    /**
     * This test needs the database to be working - this is bad practice, will be mocking it shortly.
     */
    @Ignore
    @Test
    public void testShortenUrl() {
        try {
            assertNotNull("The shorter URL should not be null", UrlShortnerServiceImpl.shortenUrl("http://funkyganesha.com"));
        } catch (UnknownHostException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @Ignore
    @Test
    public void testGetFullUrl() {
        try {
            String url = UrlShortnerServiceImpl.getFullUrl("wEkgV237Mhi2tuSE");
            assertNotNull("The returned URL should not be null", url);
        } catch (UnknownHostException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @Test
    public void testShortenUrl_with_null_input() throws UnknownHostException {
        assertNull(UrlShortnerServiceImpl.shortenUrl(null));
    }

    @Test
    public void testShortenUrl_with_empty_input() throws UnknownHostException {
        assertNull(UrlShortnerServiceImpl.shortenUrl(""));
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
