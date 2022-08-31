/**
 * @author - Chamath_Wijayarathna
 * Date :6/4/2022
 */

package com.google.springsecurity.springSecurity.service;


import com.google.springsecurity.springSecurity.model.Role;
import com.google.springsecurity.springSecurity.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String userName, String roleName);

    User getUser(String userNAme);

    List<User> getUsers();// Here Implement Limit

    List<Role> getRoles();
}
