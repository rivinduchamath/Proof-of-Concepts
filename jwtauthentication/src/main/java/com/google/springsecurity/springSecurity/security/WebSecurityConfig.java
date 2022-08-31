/**
 * @author - Chamath_Wijayarathna
 * Date :6/4/2022
 */

package com.google.springsecurity.springSecurity.security;

import com.google.springsecurity.springSecurity.filter.CustomAuthenticationFilter;
import com.google.springsecurity.springSecurity.filter.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;


@Configuration
 /* The WebSecurityConfig class is annotated with "@EnableWebSecurity"
    to enable Spring Security's web security support and provide the
    Spring MVC integration.*/
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {/* WebSecurityConfigurerAdapter, Tell to the spring How we want
                                                                        to manage application to the users and the security in application
                                                                        (Allows customization to both WebSecurity and HttpSecurity) */
    private final UserDetailsService userDetailsService;   /*Provided By Spring Security used to retrieve the user's
                                                             authentication and authorization information. (feed the user information to the Spring security API.)*/
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {  /*AuthenticationManagerBuilder Allows for easily
                                                                                 building in memory authentication,
                                                                                 LDAP authentication, JDBC based authentication etc...*/

        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder); // Defined PasswordEncoder bean in Main Class
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
        CustomAuthenticationFilter customAuthenticationFilter =
                new CustomAuthenticationFilter(authenticationManagerBean());// calling authenticationManagerBean() bean
        customAuthenticationFilter.setFilterProcessesUrl("/api/login");
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        // Allow to access Request from Below any URLs
        http.authorizeRequests().antMatchers("/api/login/**","/api/token/refresh/**").permitAll();
        http.authorizeRequests().antMatchers("/swagger-ui.html/**").permitAll();
        // Allow to access Request from Below URLs with having authorized Roles
        http.authorizeRequests().antMatchers(GET, "/api/user/**").hasAnyAuthority("ROLE_USER");
        http.authorizeRequests().antMatchers(POST, "/api/user/save/**").hasAnyAuthority("ROLE_ADMIN");
        // http.authorizeRequests().antMatchers(POST, "/api/user/update/**").hasAnyAuthority("ROLE_SUPER_ADMIN");
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean(); // Calling webSecurityConfigureAdapter Class to return AuthenticationManagerDelegator which return authenticationBuilder and context
    }
}
