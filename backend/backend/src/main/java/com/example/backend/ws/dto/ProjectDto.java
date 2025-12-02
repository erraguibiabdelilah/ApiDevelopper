package com.example.backend.ws.dto;

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
    private Long userId;
    private List<EntityDefinitionDto> entitydtos;
}