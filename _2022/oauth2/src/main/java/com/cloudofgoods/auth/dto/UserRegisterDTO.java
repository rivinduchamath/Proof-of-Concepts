package com.cloudofgoods.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserRegisterDTO {

    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    //Todo:: @ValidPassword
    @NotEmpty
    private String password;
//    //Todo:: @ValidPassword
//    private String matchingPassword;

    //Todo::  @ValidEmail
    @NotNull
    @NotEmpty
    private String email;

}
