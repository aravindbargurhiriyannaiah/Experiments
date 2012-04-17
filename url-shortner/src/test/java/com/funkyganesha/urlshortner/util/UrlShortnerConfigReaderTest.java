package com.funkyganesha.urlshortner.util;

import com.funkyganesha.urlshortner.bean.UrlShortnerConfiguration;
import org.junit.Test;

import java.net.UnknownHostException;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class UrlShortnerConfigReaderTest {
     @Test
    public void testGet() throws UnknownHostException {
        UrlShortnerConfiguration urlShortnerConfiguration = UrlShortnerConfigReader.get();
        assertNotNull("Configuration object should not have been null. ", urlShortnerConfiguration);
        assertEquals("Invalid hostname", "127.0.0.1", urlShortnerConfiguration.getHostname());
//        assertEquals("Invalid user name", "lightlotus", urlShortnerConfiguration.getUsername());
//        assertEquals("Invalid password", "lightlotus", urlShortnerConfiguration.getPassword());
        assertEquals("Invalid port number", 27017, urlShortnerConfiguration.getPort());
        assertEquals("Invalid database name", "urlShortner" , urlShortnerConfiguration.getDatabase());
        assertEquals("Invalid collection name", "shorturls", urlShortnerConfiguration.getCollectionName());
//        assertTrue("Authentication should be enabled", urlShortnerConfiguration.getAuthenticationRequired());
    }



    @Test
    public void test_With_dependency_injection() {
        /*
         * I should have a method of supplying an xml, xsd and a context path, this will allow me to test more scenarios.
         * Should invoidvestigate if a DI methodology will help, GUICE seems interesting!
         */
    }
}
