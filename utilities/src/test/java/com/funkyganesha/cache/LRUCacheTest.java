package com.funkyganesha.cache;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

/**
 *
 */
public class LRUCacheTest {
    public static final int NO_OF_ELEMENTS_IN_CACHE = 5;
    private Cache cache;

    @Before
    public void setUp() throws Exception {
        cache = new LRUCache();
        cache.setCacheSize(NO_OF_ELEMENTS_IN_CACHE);
    }

    @Test
    public void testPut() {
        for (int i = 0; i < 100; i++) {
            cache.put(RandomStringUtils.randomAlphabetic(NO_OF_ELEMENTS_IN_CACHE), new Object());
            if (i > NO_OF_ELEMENTS_IN_CACHE) {
                assertEquals("Invalid cache size.", NO_OF_ELEMENTS_IN_CACHE, cache.getCurrentCacheSize());
            }
        }
    }

    @Test
    public void testGet() {
        cache.put("1", "1");
        cache.put("2", "2");
        cache.put("3", "3");
        cache.put("4", "4");
        cache.put("5", "5");
        Object objectFromCache = cache.get("1");
        Object mostRecentlyUsedObjectInCache = cache.getMRU();
        assertNotNull("Returned object should not be null as it is there in the cache.", objectFromCache);
        assertNotNull("Returned object should not be null as it is there in the cache.", mostRecentlyUsedObjectInCache);
        assertEquals("Invalid object returned as most recently used", objectFromCache, mostRecentlyUsedObjectInCache);
        String str = (String) objectFromCache;
        assertEquals("Invalid value", "1", str);
    }

    @Test
    public void testPutWithNullKey() {
        cache.put(null, new Object());
        assertEquals("Invalid cache size", 0, cache.getCurrentCacheSize());
    }

    @Test
    public void testPutWithEmptyKey() {
        cache.put("", new Object());
        assertEquals("Invalid cache size", 0, cache.getCurrentCacheSize());
    }

    @Test
    public void testGetWithEmptyKey() {
        Object result = cache.get("");
        assertNull("Incorrect element returned.", result);
    }

    @Test
    public void testGetWithNullKey() {
        Object result = cache.get("");
        assertNull("Incorrect element returned.", result);
    }

}
