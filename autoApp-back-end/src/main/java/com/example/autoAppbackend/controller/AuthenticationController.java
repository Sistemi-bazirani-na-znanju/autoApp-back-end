package com.example.autoAppbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import com.example.autoAppbackend.dto.AuthenticationRequest;
import com.example.autoAppbackend.dto.AuthenticationResponse;
import com.example.autoAppbackend.dto.UserDTO;
import com.example.autoAppbackend.exeption.ResourceConflictException;
import com.example.autoAppbackend.model.User;
import com.example.autoAppbackend.service.AuthenticationService;
import com.example.autoAppbackend.service.UserService;
import com.example.autoAppbackend.util.TokenUtils;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final AuthenticationManager authenticationManager;
    private final TokenUtils tokenUtils;

    @Autowired
    UserService userService;


    @PostMapping(value = "/register", consumes = "application/json")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody UserDTO request) {
        System.out.println("REGISTER method hit!" + request.getEmail());
        User existingUser = userService.findByEmail(request.getEmail());

        if (existingUser != null) {
            throw new ResourceConflictException(request.getId(), "Username already exists");
        }

        User registeredUser = authenticationService.register(request);

        if (registeredUser != null) {
            return ResponseEntity.ok(
                    authenticationService.authenticate(
                            new AuthenticationRequest(request.getEmail(), request.getPassword())
                    )
            );
        } else {
            throw new ResourceConflictException(request.getId(), "Authentication faild");
        }

    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Helloooasdas");
    }


}
