package com.example.backend.services.meta.impl;
import com.example.backend.dao.AttributeDefinitionRepository;
import com.example.backend.entity.AttributeDefinition;
import com.example.backend.services.meta.facade.AttributeDefinitionService;
import com.example.backend.ws.convertir.AttributeConvertir;
import com.example.backend.ws.dto.AttributeDefinitionDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class AttributeDefinitionServiceImpl implements AttributeDefinitionService {

    private final AttributeDefinitionRepository dao;
    private final AttributeConvertir convertir;

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
    public int save(AttributeDefinitionDto attributeDefinitionDto) {
        if (attributeDefinitionDto.getEntity_id()==null) return -1;
        if(attributeDefinitionDto.getName()==null
                || attributeDefinitionDto.getType()==null)  return -2;
        AttributeDefinition attributeDefinition=convertir.toBean(attributeDefinitionDto);
        dao.save(attributeDefinition);
        return 1;
    }

    @Override
    public List<AttributeDefinition> findAll() {
        return dao.findAll();
    }

    public AttributeDefinitionServiceImpl(AttributeDefinitionRepository dao, AttributeConvertir convertir) {
        this.dao = dao;
        this.convertir=convertir;
    }
}
