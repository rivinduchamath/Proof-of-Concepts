package com.cloudofgoods.auth.service.impl;

import com.cloudofgoods.auth.dao.PermissionDetailsRepository;
import com.cloudofgoods.auth.entity.Permission;
import com.cloudofgoods.auth.service.PermissionDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PermissionDetailsServiceImpl implements PermissionDetailsService {
    final PermissionDetailsRepository permissionDetailsRepository;

    @Override
    public String savePermission(String permissionName) {

        permissionDetailsRepository.save(new Permission(null, permissionName));
        return permissionName;
    }

    @Override
    public boolean delete(Integer permissionId) {
        return permissionDetailsRepository.deletePermissionById(permissionId);
    }
}
