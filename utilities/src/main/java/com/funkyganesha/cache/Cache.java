package com.funkyganesha.cache;

/**
 *
 */
public interface Cache {
    void put(String key, Object object);

    Object get(String key);

    void setCacheSize(int noOfElementsInCache);

    int getCurrentCacheSize();

    /**
     *
     * @return The least recently used object in the cache
     */
    Object getLRU();

    /**
     *
     * @return The most recently used object in the cache
     */
    Object getMRU();
}
