package com.cloudofgoods.auth.service.impl;

import com.cloudofgoods.auth.dao.RoleDetailsRepository;
import com.cloudofgoods.auth.entity.Permission;
import com.cloudofgoods.auth.entity.Role;
import com.cloudofgoods.auth.service.RoleDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Service
public class RoleDetailsServiceImpl implements RoleDetailsService {

    private final RoleDetailsRepository roleDetailRepository;

    @Override
    public String removePermissionFromRole(String roleName, Permission permission) {
        // Find Role If Exists
        Optional<Role> optionalRole = roleDetailRepository.findRoleByName(roleName);
        // Get All Permissions

        Role roleDetails = new Role(optionalRole.get());

        List<Permission> list = new ArrayList<>();
        for (Permission p : roleDetails.getPermissions()) {
            if (!p.equals(permission)) {
                if (!list.contains(p)) list.add(p);
            }
        }
        roleDetails.setPermissions(list);
        Role save = roleDetailRepository.save(roleDetails);
        if (!ObjectUtils.isEmpty(save)) {
            return "Remove Permission Successfully";
        } else {
            return "Permission Remove Fail";
        }
    }

    @Override
    public String assignPermissionToRole(String roleName, Permission permission) {
        Optional<Role> optionalRole = roleDetailRepository.findRoleByName(roleName);
        Role save = null;
        if (optionalRole.isPresent()) {
            // Get All Permissions
            Role roleDetails = new Role(optionalRole.get());
            List<Permission> currentPermission = roleDetails.getPermissions();
            for (Permission p : currentPermission) {
                if (!p.equals(permission)) {
                    if (!currentPermission.contains(p)) currentPermission.add(p);
                }
            }
            roleDetails.setPermissions(currentPermission);
            save = roleDetailRepository.save(roleDetails);
        }
        if (!ObjectUtils.isEmpty(save)) {
            return "Assign Permission Successfully";
        } else {
            return "Permission Assign Fail";
        }

    }

    @Override
    public String createRole(String roleName) {
        Role yourObject = roleDetailRepository.save(new Role(null, roleName));
        if (!ObjectUtils.isEmpty(yourObject)) {
            return "Role Save Successfully";
        } else {
            return "Role Save Fail";
        }
    }

    @Override
    @Transactional
    public int removeRole(String roleName) {
        return roleDetailRepository.deleteRoleByName(roleName);

    }
}
