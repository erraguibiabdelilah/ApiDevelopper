package com.example.backend.ws.convertir;

import com.example.backend.entity.AttributeDefinition;
import com.example.backend.entity.EntityDefinition;
import com.example.backend.ws.dto.AttributeDefinitionDto;
import org.springframework.stereotype.Component;

@Component
public class AttributeConvertir {

    public AttributeDefinition toBean(AttributeDefinitionDto dto){
        AttributeDefinition bean=new AttributeDefinition();
        bean.setId(dto.getId());
        bean.setName(dto.getName());
        bean.setLength(dto.getLength());
        bean.setType(dto.getType());
        bean.setRequired(dto.isRequired());
        bean.setUniqueField(dto.getUniqueField());
        bean.setDefaultValue(dto.getDefaultValue());
        bean.setEnumValues(dto.getEnumValues());

        EntityDefinition entityDefinition=new EntityDefinition();
        if (dto.getEntity_id()!=null){
            entityDefinition.setId(dto.getEntity_id());
            bean.setEntityDefinition(entityDefinition);
        }
        return bean;
    }

    public AttributeDefinitionDto toDto(AttributeDefinition bean){
        AttributeDefinitionDto
    }
}
