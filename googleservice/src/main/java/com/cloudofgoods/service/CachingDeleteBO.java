package com.cloudofgoods.service;

public interface CachingDeleteBO {

    // Evict All Cache
    void deleteAllCache();

    void deleteSingleCacheValue(String cacheKey);
}
