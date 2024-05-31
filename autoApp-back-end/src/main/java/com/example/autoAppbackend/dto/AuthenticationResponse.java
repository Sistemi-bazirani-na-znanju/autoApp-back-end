package com.example.autoAppbackend.dto;
import lombok.Data;

@Data
public class AuthenticationResponse {

    private String accessToken;
    private Long expiresIn;

    public AuthenticationResponse() {
        this.accessToken = null;
        this.expiresIn = null;
    }

    public AuthenticationResponse(String accessToken, long expiresIn) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
    }
}
