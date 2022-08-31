package com.cloudofgoods.service.impl.eviction;

import com.cloudofgoods.service.CachingDeleteBO;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CachingEvictBOImpl implements CachingDeleteBO {
    private final CacheManager cacheManager;


    @CacheEvict(value = "root", key = "#cacheKey")
    public void deleteSingleCacheValue( String cacheKey) {
        Objects.requireNonNull(cacheManager.getCache("root")).evict(cacheKey);
    }

    @Description("Remove all Cache")
    @CacheEvict(value = "root", allEntries = true)
    public void deleteAllCache() {
        cacheManager.getCacheNames()
                .parallelStream()
                .forEach(cacheName -> Objects.requireNonNull(cacheManager.getCache(cacheName)).clear());
    }


}
