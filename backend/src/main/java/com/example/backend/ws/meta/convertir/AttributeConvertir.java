package com.example.backend.ws.meta.convertir;

import com.example.backend.entity.AttributeDefinition;
import com.example.backend.entity.EntityDefinition;
import com.example.backend.ws.meta.dto.AttributeDefinitionDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AttributeConvertir {

    public AttributeDefinition toBean(AttributeDefinitionDto dto){
        if (dto == null) return null;

        AttributeDefinition bean = new AttributeDefinition();

        bean.setId(dto.getId());
        bean.setName(dto.getName());
        bean.setLength(dto.getLength());
        bean.setType(dto.getType());
        bean.setRequired(dto.isRequired());
        bean.setUniqueField(dto.getUniqueField());
        bean.setDefaultValue(dto.getDefaultValue());
        bean.setEnumValues(dto.getEnumValues());

        if (dto.getEntity_id() != null){
            EntityDefinition entityDefinition = new EntityDefinition();
            entityDefinition.setId(dto.getEntity_id());
            bean.setEntityDefinition(entityDefinition);
        }

        return bean;
    }

    public AttributeDefinitionDto toDto(AttributeDefinition bean){
        if (bean == null) return null;

        AttributeDefinitionDto dto = new AttributeDefinitionDto();

        dto.setId(bean.getId());
        dto.setName(bean.getName());
        dto.setLength(bean.getLength());
        dto.setType(bean.getType());
        dto.setRequired(bean.isRequired());
        dto.setUniqueField(bean.getUniqueField());
        dto.setDefaultValue(bean.getDefaultValue());
        dto.setEnumValues(bean.getEnumValues());

        if (bean.getEntityDefinition() != null) {
            dto.setEntity_id(bean.getEntityDefinition().getId());
        }

        return dto;
    }


    public List<AttributeDefinition> toBeans(List<AttributeDefinitionDto> dtos){
        if (dtos == null) return null;

        return dtos.stream()
                .map(this::toBean)
                .collect(Collectors.toList());
    }


    public List<AttributeDefinitionDto> toDtos(List<AttributeDefinition> beans){
        if (beans == null) return null;

        return beans.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
