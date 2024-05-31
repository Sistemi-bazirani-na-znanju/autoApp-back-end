package com.example.autoAppbackend.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.autoAppbackend.model.User;
import com.example.autoAppbackend.repository.UserRepository;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getById(Long id) {
        return userRepository.findUserById(id);
    }

    public User findByEmail(String email) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(email);
    }

    

}
