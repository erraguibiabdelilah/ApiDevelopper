package com.example.backend.ws.meta.dto;

import com.example.backend.entity.AttributeType;
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
    private Long  entity_id;
}
