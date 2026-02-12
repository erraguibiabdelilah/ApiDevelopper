package com.example.backend.security.services.facad;


import com.example.backend.security.bean.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    public String signIn(User user);
    public User save(User user );


    List<User> findAll();
}
