package com.cloudofgoods.auth.dao;


import com.cloudofgoods.auth.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleDetailsRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findRoleByName(String userName);
    int deleteRoleByName(String roleName);
}
