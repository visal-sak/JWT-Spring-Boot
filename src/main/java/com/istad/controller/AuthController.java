package com.istad.controller;

import com.istad.model.Request.UserRequest;
import com.istad.service.TokenService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final TokenService tokenService;
    AuthController(TokenService tokenService){
        this.tokenService = tokenService;
    }

    @PostMapping("/token")
    public String getToke(@RequestBody UserRequest userRequest){
        try {
            System.out.println("here data :"+userRequest);
            Authentication authentication=new UsernamePasswordAuthenticationToken(
                    userRequest.getUsername(),
                    userRequest.getPassword()
            );
//        String token= tokenService.generateToken(authentication);
            return "successfully";
        }catch (Exception ex){
            return "failed";
        }
    }
    @GetMapping("/gettoken")
    public String hello(Authentication authentication){
        String token= tokenService.generateToken(authentication);
        return token;
    }

}

