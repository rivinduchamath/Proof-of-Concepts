package com.cloudofgoods.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "oauth_code")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OauthCode implements SuperEntity {
    @Id
    @Column(name = "code")
    private String code;
    @Column(name = "authentication")
    private Long authentication;


}

