package com.cloudofgoods.auth.configarations.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    protected AuthenticationManager getAuthenticationManager() throws Exception {
        return super.authenticationManagerBean();
    }

//    @Order(1)
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        //configure your path here
//        http.authorizeRequests().antMatchers(OAuth2ServerConfiguration.AUTH_WHITELIST).permitAll();
//    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}