package com.cloudofgoods.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "oauth_client_token")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OauthClientToken implements SuperEntity {
    @Id
    @Column(name = "token_id")
    private String tokenId;
    @Column(name = "token", columnDefinition = "MEDIUMBLOB")
    @Lob
    private Long token;
    @Column(name = "authentication_id")
    private String authenticationId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "client_id")
    private String clientId;
}

