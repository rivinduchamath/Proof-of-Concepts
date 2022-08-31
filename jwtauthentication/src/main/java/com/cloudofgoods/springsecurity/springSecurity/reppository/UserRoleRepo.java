package com.cloudofgoods.springsecurity.springSecurity.reppository;

import com.cloudofgoods.springsecurity.springSecurity.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepo extends JpaRepository<UserRole, Long> {
}
