package com.istad.service.UserServiceImp;

import com.istad.model.User;
import com.istad.repository.UserRepo;
import com.istad.service.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    @Override
    public User FindUserName(String name) throws UsernameNotFoundException {
        User user=userRepo.findUserByName(name).stream().findAny().orElse(null);
        System.out.println("here is the authentication : " +user);
        if(user==null){
            throw new UsernameNotFoundException("Authentication User don't exist!");
        }
        org.springframework.security.core.userdetails.User user1= (org.springframework.security.core.userdetails.User) org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole()).build();
        return  user;
    }
}
