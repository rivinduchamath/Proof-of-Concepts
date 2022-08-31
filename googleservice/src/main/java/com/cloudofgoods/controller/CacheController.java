package com.cloudofgoods.controller;

import com.cloudofgoods.service.CachingDeleteBO;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v5/google-service")
public class CacheController {
    private final CachingDeleteBO cachingService;

    @GetMapping("/caches/delete")
    public void deleteAllCaches() {
        cachingService.deleteAllCache();
    }

    @GetMapping("/caches/single/delete")
    public void deleteSingleCacheValue() {
        cachingService.deleteSingleCacheValue(" uk");
    }
}
