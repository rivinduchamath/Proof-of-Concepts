/**
 * @author - Chamath_Wijayarathna
 * Date :6/4/2022
 */

package com.cloudofgoods.springsecurity.springSecurity.dto;

import lombok.Data;

@Data
public class RoleToUserForm {
    private String userName;
    private String roleName;
}
