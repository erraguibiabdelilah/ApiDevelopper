package com.example.backend.services.facade;


import com.example.backend.entity.AttributeDefinition;
import com.example.backend.ws.dto.AttributeDefinitionDto;

import java.util.List;
public interface AttributeDefinitionService {



    AttributeDefinition findByIdAndEntityDefinition_Id(Long attribute_id, Long entiy_id);

    AttributeDefinition findAttributeDefinitionsByNameAndEntityDefinition_Id(String name, Long entityDefinitionId);

    List<AttributeDefinition> findAttributeDefinitionsByEntityDefinition_Id(Long entityDefinitionId);

    AttributeDefinition findAttributeDefinitionsById(Long id);

    int save(AttributeDefinitionDto attributeDefinitionDto);

    List<AttributeDefinition> findAll();
}
