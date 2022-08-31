package com.cloudofgoods.auth.dao;

import com.cloudofgoods.auth.entity.OauthClientDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDetailsRepository extends JpaRepository<OauthClientDetails, String> {
}
