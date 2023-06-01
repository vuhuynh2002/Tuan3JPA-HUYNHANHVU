package com.tuan3jpa.tuan3jpa.Repository;

import com.tuan3jpa.tuan3jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IuserRepository extends JpaRepository<User,Long> {
    @Query("select u from User u where u.username= ?1")
    User findByUsername(String username);




}
