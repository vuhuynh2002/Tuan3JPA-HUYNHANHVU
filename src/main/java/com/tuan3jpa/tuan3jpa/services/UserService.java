package com.tuan3jpa.tuan3jpa.services;

import com.tuan3jpa.tuan3jpa.Repository.IuserRepository;
import com.tuan3jpa.tuan3jpa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    private IuserRepository userRepository;

    public void save(User user)
    {
        userRepository.save(user);
    }


}
