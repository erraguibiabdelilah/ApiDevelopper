package com.example.backend.ws.convertir;

import com.example.backend.entity.EntityDefinition;
import com.example.backend.entity.Project;
import com.example.backend.ws.dto.EntityDefinitionDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class EntityConvertir {

    private final AttributeConvertir convertir;

    public EntityConvertir(AttributeConvertir convertir) {
        this.convertir = convertir;
    }

    public EntityDefinition toBean(EntityDefinitionDto dto){
        EntityDefinition bean=new EntityDefinition();
        bean.setId(dto.getId());
        bean.setEntityName(dto.getEntityName());
        //remplir seuelment l'ide de project
        Project project=new Project();
        if (dto.getProject_id()!=null) {
            project.setId(dto.getProject_id());
            bean.setProject(project);
        }
        bean.setAttributes(convertir.toBeans(dto.getAttributeDefinitionDtos()));
        return bean;
    }

    public EntityDefinitionDto toDto(EntityDefinition bean){
        EntityDefinitionDto dto=new EntityDefinitionDto();
        dto.setId(bean.getId());
        dto.setEntityName(bean.getEntityName());
        //le dto posséde seuelemnt l'id de project avec un type Long , je suis besoin d'envoyer tous l'object
        if (bean.getProject() != null) {
            dto.setProject_id(bean.getProject().getId());
        }
        dto.setAttributeDefinitionDtos(convertir.toDtos(bean.getAttributes()));
        return dto;
    }


    public List<EntityDefinition> toBeans(List<EntityDefinitionDto> dtos){
        List<EntityDefinition> beans=new ArrayList<>();
        for (EntityDefinitionDto dto:dtos){
            EntityDefinition bean=toBean(dto);
            beans.add(bean);
        }
        return beans;
    }

    public List<EntityDefinitionDto> toDtos(List<EntityDefinition> beans){
        List<EntityDefinitionDto> dtos =new ArrayList<>();
        for (EntityDefinition bean:beans){
            EntityDefinitionDto dto=toDto(bean);
            dtos.add(dto);
        }
        return dtos;
    }
}
