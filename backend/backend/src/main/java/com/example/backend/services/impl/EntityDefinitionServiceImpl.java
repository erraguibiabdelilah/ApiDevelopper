package com.example.backend.services.impl;

import com.example.backend.dao.EntityDefinitionRepository;
import com.example.backend.entity.EntityDefinition;
import com.example.backend.services.facade.EntityDefinitionServices;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class EntityDefinitionServiceImpl implements EntityDefinitionServices {

    private final EntityDefinitionRepository dao;
    @Override
    public EntityDefinition findEntityDefinitionById(Long id) {
        return dao.findEntityDefinitionById(id);
    }
    @Override
    public EntityDefinition findByEntityNameAndProjectId(String entityName, Long projectId) {
        return dao.findByEntityNameAndProjectId(entityName, projectId);
    }
    @Override
    public boolean existsByEntityNameAndProjectId(String entityName, Long projectId) {
        return dao.existsByEntityNameAndProjectId(entityName, projectId);
    }
    @Override
    public List<EntityDefinition> findByProjectId(Long projectId) {
        return dao.findByProjectId(projectId);
    }
    @Override
    public int save(EntityDefinition entityDefinition) {
        if (entityDefinition.getProject()==null) return -1;
        if (entityDefinition.getEntityName()==null) return -2;
        if(existsByEntityNameAndProjectId(entityDefinition.getEntityName(),entityDefinition.getProject().getId())) return -3;
        dao.save(entityDefinition);
        return 1;
    }

    @Override
    public int update(EntityDefinition entityDefinition){
        EntityDefinition oldEntity=findEntityDefinitionById(entityDefinition.getId());
        if(oldEntity==null) return -1;

        oldEntity.setEntityName(entityDefinition.getEntityName());
        dao.save(oldEntity);
        return 1;
    }
    @Override
    public List<EntityDefinition> findAll() {
        return dao.findAll();
    }
    @Override
    public int deleteById(Long id) {
        dao.deleteById(id);
        return 1;
    }

    public EntityDefinitionServiceImpl(EntityDefinitionRepository dao) {
        this.dao = dao;
    }
}
