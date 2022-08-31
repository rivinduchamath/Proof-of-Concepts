package com.cloudofgoods.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "auth_role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements SuperEntity {
    public static final int ROLE_user = 3;
    public static final int ROLE_admin = 1;
    public static final int ROLE_operator = 2;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name", unique = true)
    private String name;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "permission_role", joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "permission_id", referencedColumnName = "id")})
    private List<Permission> permissions;


    public Role(Role role) {
        this.id = role.getId();
        this.name = role.getName();
        this.permissions = role.getPermissions();
    }

    public Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
