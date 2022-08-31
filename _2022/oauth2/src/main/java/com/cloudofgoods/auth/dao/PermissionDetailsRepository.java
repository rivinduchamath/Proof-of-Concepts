package com.cloudofgoods.auth.dao;

import com.cloudofgoods.auth.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionDetailsRepository extends JpaRepository<Permission, Integer> {
    boolean deletePermissionById(Integer permissionId);
}
