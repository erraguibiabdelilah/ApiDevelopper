package com.example.backend.services.impl;

import com.example.backend.dao.EntityDefinitionRepository;
import com.example.backend.dao.ProjectRepository;
import com.example.backend.entity.EntityDefinition;
import com.example.backend.entity.Project;
import com.example.backend.services.facade.EntityDefinitionServices;
import com.example.backend.ws.convertir.EntityConvertir;
import com.example.backend.ws.dto.EntityDefinitionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service

public class EntityDefinitionServiceImpl implements EntityDefinitionServices {

    private final EntityDefinitionRepository dao;
    private final ProjectRepository projectDao;

    @Autowired
    private EntityConvertir convertir;

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
    public int save(EntityDefinitionDto entityDefinitionDto) {

        if (entityDefinitionDto.getProject_id() == null) return -1;

        Project project = projectDao.findProjectById(entityDefinitionDto.getProject_id());
        if (project == null) return -2;
        if (entityDefinitionDto.getEntityName() == null) return -3;
        EntityDefinition entityDefinition = convertir.toBean(entityDefinitionDto);
        dao.save(entityDefinition);
        return 1;
    }


    @Override
    public int update(EntityDefinitionDto entityDefinitionDto) {
        if (entityDefinitionDto==null
                ||entityDefinitionDto.getId()==null
                ||entityDefinitionDto.getProject_id()==null
        )      return -1;

        EntityDefinition oldEntity =
                findEntityDefinitionById(entityDefinitionDto.getId());

        if (oldEntity == null) return -2;

        oldEntity.setEntityName(entityDefinitionDto.getEntityName());
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

    public EntityDefinitionServiceImpl(EntityDefinitionRepository dao, ProjectRepository projectDao) {
        this.dao = dao;
        this.projectDao = projectDao;
    }
}
