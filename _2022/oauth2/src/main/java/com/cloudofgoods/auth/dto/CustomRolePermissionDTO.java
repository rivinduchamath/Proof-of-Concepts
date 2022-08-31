package com.cloudofgoods.auth.dto;

import com.cloudofgoods.auth.entity.Permission;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomRolePermissionDTO {

    private String roleName;
    private Permission permission;
}
