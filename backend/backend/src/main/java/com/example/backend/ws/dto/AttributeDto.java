package com.example.backend.ws.dto;

import com.example.backend.ws.dto.EntityDefinitionDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AttributeDto {
    private String name;
    private String type;
    private boolean required;
    private String enumValues;
    private EntityDefinitionDto entityDefinition;

}