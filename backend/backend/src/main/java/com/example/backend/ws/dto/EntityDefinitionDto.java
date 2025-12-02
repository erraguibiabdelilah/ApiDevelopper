package com.example.backend.ws.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntityDefinitionDto {
    private Long id;
    private String entityName;
    private List<AttributeDto> attributesdtos;
}