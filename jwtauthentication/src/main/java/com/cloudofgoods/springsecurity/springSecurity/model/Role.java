/**
 * @author - Chamath_Wijayarathna
 * Date :6/4/2022
 */


package com.cloudofgoods.springsecurity.springSecurity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "roleId")
    private Collection<UserRole> users = new HashSet<>();

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
