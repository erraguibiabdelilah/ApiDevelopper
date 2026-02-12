package com.example.backend.ws.dto;

import com.example.backend.entity.AttributeType;
import com.example.backend.entity.EntityDefinition;
import com.example.backend.ws.dto.EntityDefinitionDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AttributeDefinitionDto {
    private Long id;
    private String name;
    private AttributeType type;
    private boolean required;
    private Integer length;
    private Boolean uniqueField;
    private String defaultValue;
    private List<String> enumValues;
    private EntityDefinition entityDefinition;
}
