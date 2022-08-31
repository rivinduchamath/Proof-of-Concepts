package com.cloudofgoods.auth.dto;

import com.cloudofgoods.auth.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomUserRoleDTO {

    private String userName;
    private Role role;
}
