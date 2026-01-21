package com.example.backend.security.ws.admin;

import com.example.backend.security.bean.User;
import com.example.backend.security.services.facad.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api_backend/api/admin/")
public class UserControllerAdmin {
    private  UserService userService;

    @GetMapping("/sign-in/")
    public String signIn(@RequestBody User user) {
        return userService.signIn(user);
    }
    @GetMapping("/username/{username}")
    public UserDetails loadUserByUsername(@PathVariable String username) throws UsernameNotFoundException {
        return userService.loadUserByUsername(username);
    }
    @PostMapping("/")
    public User save(@RequestBody  User user) {
        return userService.save(user);
    }
    @GetMapping("/")
    public List<User> findAll() {
        return userService.findAll();
    }

    public UserControllerAdmin(UserService userService){
        this.userService=userService;
    }
}
