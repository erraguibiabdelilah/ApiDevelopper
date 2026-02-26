package com.example.backend.ws.meta.dto;

import com.example.backend.security.ws.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {
    private Long id;
    private String projectName;
    private LocalDateTime createdAt;
    private UserDto user;
    private List<EntityDefinitionDto> entitys;
}