package com.cloudofgoods.auth.controller;

import com.cloudofgoods.auth.dto.AccountLockUnlockDTO;
import com.cloudofgoods.auth.dto.CustomUserRoleDTO;
import com.cloudofgoods.auth.dto.UserDTO;
import com.cloudofgoods.auth.dto.UserRegisterDTO;
import com.cloudofgoods.auth.service.UserDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
/*
* This Class Contains All User Related Functionalities
* and Authentication and without authentication Both.
* */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v5/oauth/user")
@Slf4j
public class UserController {

    private final UserDetailService userDetailService;

    @Description("Register User To the System With Business address and all (For Testing ")
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public UserRegisterDTO registerUser(@RequestBody @Valid UserRegisterDTO registrationRequest) {
        UserRegisterDTO userRegisterDTO = null;
        try {
            userRegisterDTO = userDetailService.registerUser(registrationRequest);
        } catch (Exception e) {
        log.error("User "+registrationRequest.getUsername() +" Register Failed" );
        }
        return userRegisterDTO;
    }

    @Description("Register Customer To the system without role or authentication")
    @RequestMapping(value = "/customer/registration", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public UserRegisterDTO registerCustomer(@RequestBody UserRegisterDTO registrationRequest) {
        UserRegisterDTO userRegisterDTO = null;
        try {
            userRegisterDTO = userDetailService.registerUser(registrationRequest);
        } catch (Exception e) {
            log.error("User "+registrationRequest.getUsername() +" Register Failed" );
        }
        return userRegisterDTO;
    }

    @RequestMapping(value = "/account-lock-unlock", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public String lockUserAccount(@RequestBody AccountLockUnlockDTO accountLockUnlockDTO, HttpServletRequest request) {
        return userDetailService.lockOrUnlockUserAccount(accountLockUnlockDTO);
    }

    @RequestMapping(value = "/resources", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String assignRoleToUser() {
        return "test";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/remove-role")
    @ResponseStatus(HttpStatus.OK)
    public String removeRoleFromUser(@RequestBody CustomUserRoleDTO customUserRole) {
        return userDetailService.removeRoleFromUser(customUserRole.getUserName(), customUserRole.getRole());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get-all-users")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> revokeToken() {
        return userDetailService.findAllUsers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getuser")
    @ResponseStatus(HttpStatus.OK)
    public Optional<UserDTO> getUser(HttpServletRequest request) {
        String userName = request.getHeader("userName");
        return userDetailService.getUserById(userName);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    @ResponseStatus(HttpStatus.OK)
    public String check(HttpServletRequest request) {
        return "from auth service";
    }
}
