/**
 * @author - Chamath_Wijayarathna
 * Date :6/4/2022
 */

package com.google.springsecurity.springSecurity.reppository;


import com.google.springsecurity.springSecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUserName(String userName);
}
