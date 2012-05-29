package com.funkyganesha.cache;


import java.util.LinkedList;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * Cache that removes the least recently used (key, value) pair.
 */
public class LRUCache implements Cache {
    private LinkedList<String> list = Lists.newLinkedList();
    private Map<String, Object> cache = Maps.newHashMap();
    public static int DEFAULT_NO_OF_ELEMENTS_IN_CACHE = 10;
    private int noOfElementsInCache = DEFAULT_NO_OF_ELEMENTS_IN_CACHE;

    public void put(String key, Object object) {
        if (StringUtils.isNotBlank(key)) {
            if (cache.size() == noOfElementsInCache) {
                evictLRU();
            }
            cache.put(key, object);
            list.addFirst(key);
        }
    }

    private void evictLRU() {
        if (CollectionUtils.isNotEmpty(list)) {
            cache.remove(list.removeLast());
        }
    }

    public Object get(String key) {
        Object result = null;
        if (StringUtils.isNotBlank(key)) {
            result = cache.get(key);
            list.addFirst(list.removeLast());
        }
        return result;
    }

    public void setCacheSize(int noOfElementsInCache) {
        this.noOfElementsInCache = noOfElementsInCache;
    }

    public int getCurrentCacheSize() {
        return cache.size();
    }

    public Object getLRU() {
        return list.peekLast();
    }

    public Object getMRU() {
        return list.peekFirst();
    }
}
