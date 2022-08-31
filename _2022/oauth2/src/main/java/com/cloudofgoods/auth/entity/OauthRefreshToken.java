package com.cloudofgoods.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.Table;


@Table(name = "oauth_refresh_token")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OauthRefreshToken implements SuperEntity {

    @Column(name = "token_id")
    private String tokenId;

    @Column(name = "token", columnDefinition = "MEDIUMBLOB")
    @Lob
    private Long token;

    @Column(name = "authentication")
    private Long authentication;

}

