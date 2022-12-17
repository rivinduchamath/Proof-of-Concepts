package com.cloudofgoods.catalog.controller;


import com.cloudofgoods.catalog.business.CachingDeleteBO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v5/category")
@Slf4j
public class CacheController {
    private final CachingDeleteBO cachingService;

    @GetMapping("/caches/delete")
    public void deleteAllCaches() {
        log.info("Log::CacheController deleteAllCaches()");
        cachingService.deleteAllCache();
    }
}
