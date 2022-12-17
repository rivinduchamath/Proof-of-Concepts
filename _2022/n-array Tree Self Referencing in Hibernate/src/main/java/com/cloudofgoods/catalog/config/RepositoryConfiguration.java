package com.cloudofgoods.catalog.config;

import com.cloudofgoods.catalog.events.ItemEventHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration{

    public RepositoryConfiguration(){
        super();
    }

    @Bean
    ItemEventHandler authorEventHandler() {
        return new ItemEventHandler();
    }
}