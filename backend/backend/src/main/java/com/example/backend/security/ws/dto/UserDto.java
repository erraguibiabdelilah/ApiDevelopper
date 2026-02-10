package com.example.backend.security.ws.dto;

import com.example.backend.security.bean.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserDto {
    private Long id ;
    private String name;
    private String username;
    private Collection<Role> authorities; //roles
}
