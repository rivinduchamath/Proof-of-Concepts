/**
 * @author - Chamath_Wijayarathna
 * Date :6/4/2022
 */

package com.google.springsecurity.springSecurity.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data // Create Getters Setters
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(name = "user_Name", length = 50, unique = true)
    private String userName; // Email or Unique
    private String password;
    @OneToMany(mappedBy = "userId")
    private Set<UserRole> roles = new HashSet<>();


    public User(Long id, String name, String userName, String password) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
    }

    public Collection<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }
}
