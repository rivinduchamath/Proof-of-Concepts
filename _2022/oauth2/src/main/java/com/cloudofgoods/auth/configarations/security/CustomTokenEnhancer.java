package com.cloudofgoods.auth.configarations.security;

import com.cloudofgoods.auth.entity.Role;
import com.cloudofgoods.auth.entity.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        final Map<String, Object> additionalInfo = new HashMap<>();
        User user = (User) oAuth2Authentication.getPrincipal();
        List<String> roles = user.getRoles().stream().map(Role::getName).collect(Collectors.toList());
        String string = String.join(", ", roles);
        String BasicBase64format = Base64.getEncoder().encodeToString(string.getBytes());
        additionalInfo.put("authorize", BasicBase64format);
        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(additionalInfo);
        return oAuth2AccessToken;
    }
}
