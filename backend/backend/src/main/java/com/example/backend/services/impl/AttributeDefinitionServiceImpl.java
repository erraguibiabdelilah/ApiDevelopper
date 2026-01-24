package com.example.backend.services.impl;

import com.example.backend.dao.AttributeDefinitionRepository;
import com.example.backend.entity.AttributeDefinition;
import com.example.backend.services.facade.AttributeDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AttributeDefinitionServiceImpl implements AttributeDefinitionService {


    private final AttributeDefinitionRepository dao;
    @Override
    public AttributeDefinition findByEntityDefinitionId(Long entityDefinitionId) {
        return dao.findByEntityDefinitionId(entityDefinitionId);
    }
    @Override
    public int save(AttributeDefinition attribute) {
        dao.save(attribute);
        return 1;
    }
    @Override
    public List<AttributeDefinition> findAll() {
        return dao.findAll();
    }

    public AttributeDefinitionServiceImpl(AttributeDefinitionRepository dao) {
        this.dao = dao;
    }
}
