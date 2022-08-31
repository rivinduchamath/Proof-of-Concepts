package com.google.configarations.security;

import com.google.model.Handler;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class BasicAuthenticationInterceptor implements HandlerInterceptor {

    public String clientSecret;

    BasicAuthenticationInterceptor(String secret) {
        this.clientSecret = secret;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authHeader = request.getHeader("Authorization");
        String getClientSecret = authHeader.split(" ")[1];
        if (clientSecret.equals(getClientSecret)) {
            return true;
        } else {
            Handler responseHandle = new Handler();

            responseHandle.setError(true);
            responseHandle.setResponseMessage("The url you are trying to reach Un-Authorized.");
            PrintWriter out = response.getWriter();
            ObjectMapper objectMapper= new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(responseHandle);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.setStatus(401);
            out.print(jsonString);
            out.flush();
            return false;
        }
    }
}
