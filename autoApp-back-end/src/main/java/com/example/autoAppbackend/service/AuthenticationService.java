package com.example.autoAppbackend.service;


import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.autoAppbackend.dto.AuthenticationRequest;
import com.example.autoAppbackend.dto.AuthenticationResponse;
import com.example.autoAppbackend.dto.UserDTO;
import com.example.autoAppbackend.model.Role;
import com.example.autoAppbackend.model.User;
import com.example.autoAppbackend.repository.UserRepository;
import com.example.autoAppbackend.util.TokenUtils;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenUtils tokenUtils;

    @Autowired
    private RoleService roleService;

    public User register(UserDTO request) {

        Role role = roleService.findByName("ROLE_USER");
    
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setRole(role);
        user.setNew(false);
        user.setSuspicious(false);

        return repository.save(user);
    }
    

    public AuthenticationResponse authenticate(AuthenticationRequest request){

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()

        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = (User) authentication.getPrincipal();
        String jwt  = tokenUtils.generateToken(user);
        int expiresIn = tokenUtils.getExpiredIn();
        return new AuthenticationResponse(jwt,expiresIn);
    }


}
