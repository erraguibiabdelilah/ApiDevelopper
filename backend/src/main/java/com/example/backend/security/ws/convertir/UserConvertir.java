package com.example.backend.security.ws.convertir;
import com.example.backend.security.bean.User;
import com.example.backend.security.ws.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserConvertir {

    public User toBean(UserDto dto){
        User bean =new User();
        bean.setId(dto.getId());
        bean.setName(dto.getName());
        bean.setUsername(dto.getUsername());
        bean.setAuthorities(dto.getAuthorities());
        return bean;
    }

    public UserDto toDto(User bean){
        UserDto dto=new UserDto();
        dto.setId(bean.getId());
        dto.setName(bean.getName());
        dto.setUsername(bean.getUsername());
        dto.setAuthorities(bean.getAuthorities());
        return dto;
    }


}
