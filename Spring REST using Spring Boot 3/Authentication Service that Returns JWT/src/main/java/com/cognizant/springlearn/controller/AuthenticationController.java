package com.cognizant.springlearn.controller;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.model.AuthenticationResponse;
import com.cognizant.springlearn.util.JwtUtil;

@RestController
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/authenticate")
    public AuthenticationResponse authenticate(
            @org.springframework.web.bind.annotation.RequestHeader(HttpHeaders.AUTHORIZATION)
            String authorizationHeader) {

        String encoded =
                authorizationHeader.substring(6);

        byte[] decodedBytes =
                Base64.getDecoder().decode(encoded);

        String credentials =
                new String(decodedBytes, StandardCharsets.UTF_8);

        String username =
                credentials.split(":")[0];

        String token =
                jwtUtil.generateToken(username);

        return new AuthenticationResponse(token);

    }

}