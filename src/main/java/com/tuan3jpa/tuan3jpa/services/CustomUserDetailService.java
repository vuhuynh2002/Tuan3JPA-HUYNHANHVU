package com.tuan3jpa.tuan3jpa.services;

import com.tuan3jpa.tuan3jpa.Repository.IuserRepository;
import com.tuan3jpa.tuan3jpa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private IuserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepository.findByUsername(username);
        if(user==null)
        {
            throw new UsernameNotFoundException("user not found");

        }
        return new CustomUserDetail(user, userRepository);
    }


}
