package com.cloudofgoods.catalog.config.configaration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;


import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class CachingConfig {
    @Bean
    RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
        return (builder) -> {
            Map<String, RedisCacheConfiguration> configurationMap = new HashMap<>();
            configurationMap.put("category", RedisCacheConfiguration.defaultCacheConfig());
            builder.withInitialCacheConfigurations(configurationMap);
        };
    }
}