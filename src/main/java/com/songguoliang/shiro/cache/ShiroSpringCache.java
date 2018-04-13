package com.songguoliang.shiro.cache;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.apache.shiro.cache.CacheException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Description 使用spring-cache作为shiro缓存
 * @Author sgl
 * @Date 2018-04-13 13:07
 */
public class ShiroSpringCache<K, V> implements org.apache.shiro.cache.Cache<K, V> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShiroSpringCache.class);
    private final Cache cache;
    private final boolean hasEhcache;

    public ShiroSpringCache(Cache cache, boolean hasEhcache) {
        if (cache == null) {
            throw new IllegalArgumentException("Cache argument cannot be null.");
        }
        this.cache = cache;
        this.hasEhcache = hasEhcache;
    }

    @Override
    public V get(K key) throws CacheException {
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace("Getting object from cache [" + this.cache.getName() + "] for key [" + key + "]key type:" + key.getClass());
        }
        Cache.ValueWrapper valueWrapper = cache.get(key);
        if (valueWrapper == null) {
            if (LOGGER.isTraceEnabled()) {
                LOGGER.trace("Element for [" + key + "] is null.");
            }
            return null;
        }
        return (V) valueWrapper.get();
    }

    @Override
    public V put(K key, V value) throws CacheException {
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace("Putting object in cache [" + this.cache.getName() + "] for key [" + key + "]key type:" + key.getClass());
        }
        V previous = get(key);
        cache.put(key, value);
        return previous;
    }

    @Override
    public V remove(K key) throws CacheException {
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace("Removing object from cache [" + this.cache.getName() + "] for key [" + key + "]key type:" + key.getClass());
        }
        V previous = get(key);
        cache.evict(key);
        return previous;
    }

    @Override
    public void clear() throws CacheException {
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace("Clearing all objects from cache [" + this.cache.getName() + "]");
        }
        cache.clear();
    }

    @Override
    public int size() {
        if (hasEhcache) {
            Object nativeCache = cache.getNativeCache();
            if (nativeCache instanceof Ehcache) {
                Ehcache ehcache = (Ehcache) nativeCache;
                return ehcache.getSize();
            }
        }
        return 0;
    }

    @Override
    public Set<K> keys() {
        if (hasEhcache) {
            Object nativeCache = cache.getNativeCache();
            if (nativeCache instanceof Ehcache) {
                Ehcache ehcache = (Ehcache) nativeCache;
                return new HashSet<>(ehcache.getKeys());
            }
        }
        return Collections.emptySet();
    }

    @Override
    public Collection<V> values() {
        if (hasEhcache) {
            Object nativeCache = cache.getNativeCache();
            if (nativeCache instanceof Ehcache) {
                Ehcache ehcache = (Ehcache) nativeCache;
                List keys = ehcache.getKeys();
                Map<Object, Element> elementMap = ehcache.getAll(keys);
                List<Object> values = new ArrayList<>();
                for (Element element : elementMap.values()) {
                    values.add(element.getObjectValue());
                }
                return (Collection<V>) values;
            }
        }
        return Collections.emptySet();
    }

    @Override
    public String toString() {
        return "ShiroSpringCache [" + this.cache.getName() + "]";
    }
}
