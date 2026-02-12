package com.example.backend.services.facade;


import com.example.backend.entity.EntityDefinition;

import java.util.List;
public interface EntityDefinitionServices {
    EntityDefinition findEntityDefinitionById(Long id);

    EntityDefinition findByEntityNameAndProjectId(String entityName, Long projectId);

    boolean existsByEntityNameAndProjectId(String entityName, Long projectId);

    List<EntityDefinition> findByProjectId(Long projectId);

    int save(EntityDefinition entityDefinition);

    int update(EntityDefinition entityDefinition);

    List<EntityDefinition> findAll();

    int deleteById(Long id);
}
