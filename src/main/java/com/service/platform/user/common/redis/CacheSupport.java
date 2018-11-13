package com.service.platform.user.common.redis;

public interface CacheSupport {

    /**
     * 刷新容器中的所有值
     * @param cacheName
     */
    void refreshCache(String cacheName);

    /**
     * 按容器以及制定键更新缓存
     * @param cacheName
     * @param cacheKey
     */
    void refreshCacheByKey(String cacheName, String cacheKey);

}
