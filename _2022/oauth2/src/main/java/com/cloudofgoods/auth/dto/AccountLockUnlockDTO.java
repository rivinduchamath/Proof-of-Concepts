package com.cloudofgoods.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountLockUnlockDTO {
 String email;
 boolean accountLockUnlockStatus;
}
