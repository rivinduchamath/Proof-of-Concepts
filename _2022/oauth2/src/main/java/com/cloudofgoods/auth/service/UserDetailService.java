package com.cloudofgoods.auth.service;

import com.cloudofgoods.auth.dto.AccountLockUnlockDTO;
import com.cloudofgoods.auth.dto.UserDTO;
import com.cloudofgoods.auth.dto.UserRegisterDTO;
import com.cloudofgoods.auth.entity.Role;

import java.util.List;
import java.util.Optional;

public interface UserDetailService {

    List<UserDTO> findAllUsers();

    Optional<UserDTO> getUserById(String userName);

    String removeRoleFromUser(String userName, Role role);

    String lockOrUnlockUserAccount(AccountLockUnlockDTO accountLockUnlockDTO);

    UserRegisterDTO registerUser(UserRegisterDTO registrationRequest);
}
