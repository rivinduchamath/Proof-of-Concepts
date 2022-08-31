package com.cloudofgoods.cache;

import com.cloudofgoods.model.locationmodel.LocationRoot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.cache.annotation.Cacheable;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;

@TestConfiguration
@Slf4j
public class TestRedisConfiguration {

    private final RedisServer redisServer;

    public TestRedisConfiguration() {
        this.redisServer = new RedisServer(6379);
    }

    @PostConstruct
    public void postConstruct() {
        redisServer.start();
    }

    @PreDestroy
    public void preDestroy() {
        redisServer.stop();
    }

    @Cacheable(key = "#index", value = "index")
    public LocationRoot getSingleLocationData(int index) {
        log.info("Test BO " + index);

        return new LocationRoot(new ArrayList<>(), " Test" + index);
    }


}