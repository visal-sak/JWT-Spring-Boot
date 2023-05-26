package com.istad.controller;


import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
  Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/home")
    public String homepage(Authentication authentication){
        var user = authentication.getPrincipal();
        logger.info("User is : {}",authentication.getPrincipal());
        logger.info("User is : {}",authentication.getCredentials());
        logger.info("User is : {}",authentication.getDetails());
        logger.info("User is : {}",authentication.getAuthorities());
        return "Hello ! this is home page";
    }
}
