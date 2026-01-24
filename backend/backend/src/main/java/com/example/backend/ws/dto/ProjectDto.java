package com.example.backend.ws.dto;

import com.example.backend.security.bean.User;
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
    private String projectName;
    private LocalDateTime createdAt;
    private User user;
}