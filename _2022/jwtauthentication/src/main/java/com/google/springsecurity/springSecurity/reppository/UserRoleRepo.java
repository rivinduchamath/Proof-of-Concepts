package com.google.springsecurity.springSecurity.reppository;

import com.google.springsecurity.springSecurity.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepo extends JpaRepository<UserRole, Long> {
}
