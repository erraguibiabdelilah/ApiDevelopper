package com.example.backend.services.facade;


import com.example.backend.entity.EntityDefinition;

import java.util.List;

public interface EntityDefinitionServices {
    EntityDefinition findByEntityNameAndProjectId(String entityName, Long projectId);

    boolean existsByEntityNameAndProjectId(String entityName, Long projectId);

    EntityDefinition findByProjectId(Long projectId);

    int save(EntityDefinition entityDefinition);

    List<EntityDefinition> findAll();
}
