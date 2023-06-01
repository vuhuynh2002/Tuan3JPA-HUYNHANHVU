package com.tuan3jpa.tuan3jpa.entity;

import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetail implements UserDetails {

    private final User user;

    public CustomUserDetail(User user){
        this.user= user;
    }



}
