package com.cloudofgoods.auth.configarations.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.*;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;
import java.util.Collections;

@Configuration
public class OAuth2ServerConfiguration {

    static final String[] AUTH_WHITELIST = {
            "/api/v5/oauth/user/customer/registration/**",
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/actuator/**",
            "/login/**"
    };
    private static final String RESOURCE_ID = "payment";

    @Configuration
    @EnableResourceServer
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) {
            resources.resourceId(RESOURCE_ID);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
//            http.authorizeRequests().anyRequest().permitAll().and().csrf().disable();;
            http.authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll()
                    .anyRequest().
                    fullyAuthenticated();
        }
    }

    @Configuration
    @EnableAuthorizationServer
    protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
        private final PasswordEncoder passwordEncoder;
        private final DataSource dataSource;
        private final AuthenticationManager authenticationManager;
        @Autowired
        private UserDetailsService userDetailsService;


        public AuthorizationServerConfiguration(AuthenticationManager authenticationManager, DataSource dataSource,
                                                PasswordEncoder passwordEncoder) {
            this.authenticationManager = authenticationManager;
            this.dataSource = dataSource;
            this.passwordEncoder = passwordEncoder;
        }

        @Bean
        TokenStore jdbcTokenStore() {
            return new JdbcTokenStore(dataSource);
        }


        @Override
        public void configure(AuthorizationServerSecurityConfigurer security) {
            security.checkTokenAccess("isAuthenticated()").tokenKeyAccess("permitAll()");
        }

        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            clients.jdbc(dataSource).passwordEncoder(passwordEncoder);
        }

        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
            endpoints.pathMapping("/oauth/check_token", "/api/v5/authorize")
                    .pathMapping("/oauth/token", "/api/v5/token");

            TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();

            tokenEnhancerChain.setTokenEnhancers(Collections.singletonList(tokenEnhancer()));

            endpoints.tokenStore(jdbcTokenStore());
            endpoints.accessTokenConverter(accessTokenConverter())
                    .tokenEnhancer(tokenEnhancerChain).
                    authenticationManager(authenticationManager).userDetailsService(userDetailsService);

        }

        @Bean
        public AccessTokenConverter accessTokenConverter() {
            AccessTokenConverter tokenConverter = new DefaultAccessTokenConverter();
            ((DefaultAccessTokenConverter) tokenConverter).setUserTokenConverter(new CustomUserAuthenticationConverter());
            return tokenConverter;
        }


        @Bean
        public TokenEnhancer tokenEnhancer() {
            return new CustomTokenEnhancer();
        }

    }
}