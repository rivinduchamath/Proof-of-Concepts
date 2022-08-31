package com.cloudofgoods.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private String clientId;

    private String clientSecret;

    private String webServerRedirectUri;

    private String scope;

    private int accessTokenValidity;

    private int refreshTokenValidity;

    private String resourceIds;

    private String authorizedGrantTypes;

    private String authorities;

    private String additionalInformation;

    private String AutoApprove;

}
