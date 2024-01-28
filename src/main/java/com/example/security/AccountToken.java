package com.example.security;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;


public class AccountToken extends JwtAuthenticationToken {

    private static final long serialVersionUID = 1L;

    // our user instance which will serve as the new principal
    private final User user;

    public AccountToken(Jwt jwt, User user) {
        super(jwt);

        // creating the User instance
        this.user = user;

        // if successful, we need to set this to true
        this.setAuthenticated(true);
    }

    @Override
    public Object getPrincipal() {

        return user;
    }
}