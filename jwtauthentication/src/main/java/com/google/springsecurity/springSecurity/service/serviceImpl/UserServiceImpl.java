/**
 * @author - Chamath_Wijayarathna
 * Date :6/4/2022
 */

package com.google.springsecurity.springSecurity.service.serviceImpl;

import com.google.springsecurity.springSecurity.model.Role;
import com.google.springsecurity.springSecurity.model.User;
import com.google.springsecurity.springSecurity.model.UserRole;
import com.google.springsecurity.springSecurity.reppository.RoleRepository;
import com.google.springsecurity.springSecurity.reppository.UserRepository;
import com.google.springsecurity.springSecurity.reppository.UserRoleRepo;
import com.google.springsecurity.springSecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    // UserService to Implement Crud to Loosely Coupling
    // Implement UserDetailsService interface to Load Users From Database
    private final UserRepository repository;
    private final RoleRepository roleRepository;
    private final UserRoleRepo userRoleRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    // Load Users from database by Using Unique userName attribute
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user = repository.findUserByUserName(userName);
        if (user == null) {
            log.error("User Name " + userName + " Not Found in the database");
            throw new UsernameNotFoundException("User Not Found on database");
        } else {
            log.info("User Name " + userName + " Found in the database");
        }
        // Create Collection to add Authorities of User
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRoleId().getName()));
        });
        // Return Username, Password List of authorities
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), authorities);
    }

    @Override
    public User saveUser(User user) {
        log.info("Inside the Save User " + user.getUserName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Inside the Save Role " + role.getName());
        return roleRepository.save(role);
    }

    // Add a Role Object To a User
    // One User May be having 1 or more Roles
    // UserName Must be Unique
    @Override
    public void addRoleToUser(String userName, String roleName) {
        User user = repository.findUserByUserName(userName);
        Role role = roleRepository.findRoleByName(roleName);
        log.info("Add Role " + roleName + " to the User " + userName);
        UserRole userRole = new UserRole(user.getId(), role.getId());
        userRole.setUserId(user);
        userRole.setRoleId(role);
        userRoleRepo.save(userRole);


    }

    @Override
    public User getUser(String userNAme) {
        log.info("Get User " + userNAme);
        return repository.findUserByUserName(userNAme);
    }

    @Override
    // Cannot be applied to a real time application
    // Should be Limit
    public List<User> getUsers() {
        log.info("Get All Users");
        return repository.findAll();
    }

    @Override
    public List<Role> getRoles() {
        log.info("Get All Roles");
        return roleRepository.findAll();
    }

}
