package com.example.backend.services.impl;

import com.example.backend.dao.EntityDefinitionRepository;
import com.example.backend.entity.EntityDefinition;
import com.example.backend.services.facade.EntityDefinitionServices;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EntityDefinitionImpl implements EntityDefinitionServices {
    @Autowired
    EntityDefinitionRepository dao;
    @Override
    public EntityDefinition findByEntityNameAndProjectId(String entityName, Long projectId) {
        return dao.findByEntityNameAndProjectId(entityName, projectId);
    }
    @Override
    public boolean existsByEntityNameAndProjectId(String entityName, Long projectId) {
        return dao.existsByEntityNameAndProjectId(entityName, projectId);
    }
    @Override
    public EntityDefinition findByProjectId(Long projectId) {
        return dao.findByProjectId(projectId);
    }
    @Override
    public int save(EntityDefinition entityDefinition) {
        dao.save(entityDefinition);
        return 1;
    }
    @Override
    public List<EntityDefinition> findAll() {
        return dao.findAll();
    }
}
