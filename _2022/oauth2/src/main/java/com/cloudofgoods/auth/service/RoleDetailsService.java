package com.cloudofgoods.auth.service;

import com.cloudofgoods.auth.entity.Permission;

public interface RoleDetailsService {
    String assignPermissionToRole(String roleName, Permission permission);

    String createRole(String roleName);

    int removeRole(String roleName);

    String removePermissionFromRole(String roleName, Permission permission);
}
