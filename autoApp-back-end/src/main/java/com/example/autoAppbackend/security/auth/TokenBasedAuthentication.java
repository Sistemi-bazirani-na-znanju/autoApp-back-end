package com.example.autoAppbackend.security.auth;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

import javax.security.auth.Subject;

public class TokenBasedAuthentication extends AbstractAuthenticationToken {

    private static final long serialVersionUID = 1L;

    private String token;
    private final UserDetails principle;

    public TokenBasedAuthentication(UserDetails principle) {
        super(principle.getAuthorities());
        this.principle = principle;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {this.token = token;}

    @Override
    public Object getCredentials() {
        return token;
    }

    @Override
    public Object getPrincipal() {
        return principle;
    }

    @Override
    public boolean implies(Subject subject) {
        return super.implies(subject);
    }
}
