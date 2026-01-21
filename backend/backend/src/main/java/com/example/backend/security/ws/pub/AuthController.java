package com.example.backend.security.ws.pub;

import com.example.backend.security.bean.User;
import com.example.backend.security.services.facad.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api_backend/auth/")
public class AuthController {
    private  UserService userService;

    @PostMapping("sign-in/")
    public String signIn(@RequestBody User user) {
        return userService.signIn(user);
    }


    @GetMapping("username/{username}")
    public UserDetails loadUserByUsername(@PathVariable String username) throws UsernameNotFoundException {
        return userService.loadUserByUsername(username);
    }


    @PostMapping("login/")
    public User save(@RequestBody  User user) {
        return userService.save(user);
    }

    public AuthController(UserService userService){
        this.userService=userService;
    }
}
