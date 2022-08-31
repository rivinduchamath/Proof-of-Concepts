package com.cloudofgoods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ApplicationGoogleService {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationGoogleService.class, args);
    }

}
