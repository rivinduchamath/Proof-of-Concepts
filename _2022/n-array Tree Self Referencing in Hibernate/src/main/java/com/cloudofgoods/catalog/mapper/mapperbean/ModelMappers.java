package com.cloudofgoods.catalog.mapper.mapperbean;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMappers {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


}
