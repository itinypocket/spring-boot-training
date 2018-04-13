package com.songguoliang.shiro.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.Destroyable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ClassUtils;

/**
 * @Description 缓存管理器 使用spring-cache作为shiro缓存
 * @Author sgl
 * @Date 2018-04-13 13:02
 */
public class ShiroSpringCacheManager implements CacheManager, Destroyable {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShiroSpringCacheManager.class);
    private org.springframework.cache.CacheManager cacheManager;
    private final boolean hasEhcache;

    public ShiroSpringCacheManager() {
        this.hasEhcache = ClassUtils.isPresent("net.sf.ehcache.Ehcache", this.getClass().getClassLoader());
    }

    public org.springframework.cache.CacheManager getCacheManager() {
        return cacheManager;
    }

    public void setCacheManager(org.springframework.cache.CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @Override
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace("Acquiring ShiroSpringCache instance named [" + name + "]");
        }
        org.springframework.cache.Cache cache = cacheManager.getCache(name);
        return new ShiroSpringCache<K, V>(cache, hasEhcache);
    }

    @Override
    public void destroy() throws Exception {
        cacheManager = null;
    }
}
