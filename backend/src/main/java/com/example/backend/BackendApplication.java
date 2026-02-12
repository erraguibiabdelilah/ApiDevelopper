package com.example.backend;

import com.example.backend.security.bean.Role;
import com.example.backend.security.bean.User;
import com.example.backend.security.services.facad.RoleService;
import com.example.backend.security.services.facad.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

    @Autowired private UserService userService;
    @Autowired private RoleService roleService;
    @Override
    public void run(String... args) throws Exception {
        Role roleUser=new Role("USER");
        Role roleAdmin=new Role("ADMIN");
        roleService.save(Set.of(roleAdmin,roleUser));
        User user=new User("abdelilah","abdelilah@erraguibi","1234");
        user.setAuthorities(Set.of(roleUser));



    }
}
