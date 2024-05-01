package com.example.autoAppbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.autoAppbackend.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findUserByEmail(String email);
    User findUserById(Long id);

}
