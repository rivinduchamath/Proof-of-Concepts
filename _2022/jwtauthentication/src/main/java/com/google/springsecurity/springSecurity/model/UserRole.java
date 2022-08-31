package com.google.springsecurity.springSecurity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRole {
    @EmbeddedId
    private UserRolePK userRolePK = new UserRolePK();

    @ManyToOne
    //@JoinColumn(name = "roleId", referencedColumnName = "id", insertable = false, updatable = false)
    @MapsId("roleId")
    private Role roleId;
    @ManyToOne
//    @JoinColumn(name = "userId", referencedColumnName = "id", insertable = false, updatable = false)
    @MapsId("userId")
    private User userId;

    public UserRole(Long roleId, Long userId) {
        this.userRolePK = new UserRolePK(roleId , userId);
    }

    public UserRole(UserRolePK userRolePK) {
        this.userRolePK = userRolePK;
    }
}
