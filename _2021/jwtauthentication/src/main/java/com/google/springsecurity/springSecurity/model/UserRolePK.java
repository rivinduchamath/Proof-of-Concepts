package com.google.springsecurity.springSecurity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@Data
@AllArgsConstructor
public class UserRolePK  implements Serializable {
 private static final long serialVersionUID = 1L;
private Long roleId;
 private Long userId;
}
