package com.example.backend.services.impl;
import com.example.backend.dao.AttributeDefinitionRepository;
import com.example.backend.entity.AttributeDefinition;
import com.example.backend.services.facade.AttributeDefinitionService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class AttributeDefinitionServiceImpl implements AttributeDefinitionService {


    private final AttributeDefinitionRepository dao;

    @Override
    public AttributeDefinition findByIdAndEntityDefinition_Id(Long attribute_id, Long entiy_id) {
        return dao.findByIdAndEntityDefinition_Id(attribute_id, entiy_id);
    }
    @Override
    public AttributeDefinition findAttributeDefinitionsByNameAndEntityDefinition_Id(String name, Long entityDefinitionId) {
        return dao.findAttributeDefinitionsByNameAndEntityDefinition_Id(name, entityDefinitionId);
    }

    @Override
    public List<AttributeDefinition> findAttributeDefinitionsByEntityDefinition_Id(Long entityDefinitionId) {
        return dao.findAttributeDefinitionsByEntityDefinition_Id(entityDefinitionId);
    }
    @Override
    public AttributeDefinition findAttributeDefinitionsById(Long id) {
        return dao.findAttributeDefinitionsById(id);
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
