package com.cloudofgoods.catalog.business.impl.eviction;

import com.cloudofgoods.catalog.business.CachingDeleteBO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class CachingEvictBOImpl implements CachingDeleteBO {
    private final CacheManager cacheManager;

    @Description("Remove all Cache")
    @CacheEvict(value = "category", allEntries = true)
    public void deleteAllCache() {
        log.info("LOG:: CachingEvictBOImpl deleteAllCache category");
        cacheManager.getCacheNames()
                .parallelStream()
                .forEach(cacheName -> Objects.requireNonNull(cacheManager.getCache(cacheName)).clear());
    }
}
