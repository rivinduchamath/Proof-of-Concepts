package com.cloudofgoods.catalog.config.configaration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Collections;
import java.util.List;

@Slf4j
@Configuration
public class CorsConfig {

    @Value("#{'${allow.headers}'.split(',')}")
    private List<String> headers;


    @Value("#{'${allow.origin}'.split(',')}")
    private List<String> origin;


    @Bean
    public FilterRegistrationBean<CorsFilter> customCorsFilter() {
        log.info("LOG::CorsConfig.customCorsFilter");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(false);
        config.setAllowedMethods(Collections.singletonList("*"));
        config.addAllowedHeader("*");
        config.setAllowedOrigins(origin);

        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));

        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}
