package com.cloudofgoods.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "oauth_approvals")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OauthApprovals implements SuperEntity {
    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "client_d")
    private String clientId;

    @Column(name = "scope")
    private String scope;

    @Column(name = "expires_at")
    private Date expiresAt;

    @Column(name = "last_modified_at")
    private Date lastModifiedAt;


}

