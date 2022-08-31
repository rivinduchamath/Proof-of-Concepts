package com.cloudofgoods.auth.controller;

import com.cloudofgoods.auth.dto.CustomRolePermissionDTO;
import com.cloudofgoods.auth.service.RoleDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v5/oauth/role")
public class RoleController {

    private final RoleDetailsService roleDetailsService;

    @RequestMapping(method = RequestMethod.POST, value = "/create/{roleName}")
    @ResponseStatus(HttpStatus.OK)
    public String createRole(@PathVariable(name = "roleName") String roleName) {
        return roleDetailsService.createRole(roleName);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/remove/{roleName}")
    @ResponseStatus(HttpStatus.OK)
    public int removeRole(@PathVariable(name = "roleName") String roleName) {
        return roleDetailsService.removeRole(roleName);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/permission/assign")
    @ResponseStatus(HttpStatus.OK)
    public String assignPermissionToRole(@RequestBody CustomRolePermissionDTO customRolePermission) {
        return roleDetailsService.assignPermissionToRole(customRolePermission.getRoleName(),
                customRolePermission.getPermission());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/permission/remove")
    @ResponseStatus(HttpStatus.OK)
    public String removePermissionFromRole(@RequestBody CustomRolePermissionDTO customRolePermission) {
        return roleDetailsService.removePermissionFromRole(customRolePermission.getRoleName(),
                customRolePermission.getPermission());
    }
}
