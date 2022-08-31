/**
 * @author - Chamath_Wijayarathna
 * Date :6/4/2022
 */

package com.cloudofgoods.springsecurity.springSecurity.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
// If we want to add unsuccessfulAuthentication() to set time after unsuccessful login
    private final AuthenticationManager authenticationManager;// want to Call Authentication manager

    public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        log.info("UserName is: {}", userName);
        log.info("Password is: {}", password);

        // Create Object UsernamePasswordAuthenticationToken
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userName, password);
        System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
        // Return Role(Authorities), Username and Credentials as Protected.
        return authenticationManager.authenticate(authenticationToken);
    }

    @Override
    //Call this method once Login Successful to create Token
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        User user = (User) authResult.getPrincipal(); // User object From Spring Security. The identity of the principal being authenticated
        Algorithm algorithm = Algorithm.HMAC256("Cpt.Chamath.jwt-secret@ILABS06-05-2022".getBytes());// From JWT Dependency. HMACSHA256 is a type of keyed hash algorithm that is constructed from the SHA-256 hash function and used as a Hash-based Message Authentication Code (HMAC).
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAaaaa");
        String access_token = JWT.create()
                .withSubject(user.getUsername()) // All UserNames are Unique
                .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))// Expire Time Mile Sec
                .withIssuer(request.getRequestURL().toString())
                .withClaim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(algorithm);// Sign In token with Algorithm

        String refresh_token = JWT.create().withSubject(user.getUsername()).withExpiresAt(new Date(System.currentTimeMillis() + 30 * 60 * 1000)).withIssuer(request.getRequestURL().toString()).sign(algorithm);

        // Print Tokens in Header
        /*  response.setHeader("access_token", access_token);
            response.setHeader("refresh_token", refresh_token);*/

        Map<String,String> token = new HashMap<>();
        token.put("access_token", access_token);
        token.put("refresh_token", refresh_token);
        response.setContentType(APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(), token);

    }
}
