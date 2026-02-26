package com.example.backend.services.meta.facade;


import com.example.backend.entity.EntityDefinition;
import com.example.backend.ws.meta.dto.EntityDefinitionDto;

import java.util.List;
public interface EntityDefinitionServices {
    EntityDefinition findEntityDefinitionById(Long id);

    EntityDefinition findByEntityNameAndProjectId(String entityName, Long projectId);

    boolean existsByEntityNameAndProjectId(String entityName, Long projectId);

    List<EntityDefinition> findByProjectId(Long projectId);



    int save(EntityDefinitionDto entityDefinitionDto);



    int update(EntityDefinitionDto entityDefinitionDto);

    List<EntityDefinition> findAll();

    int deleteById(Long id);
}
