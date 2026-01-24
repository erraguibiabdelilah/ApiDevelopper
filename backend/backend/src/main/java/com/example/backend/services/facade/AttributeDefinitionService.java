package com.example.backend.services.facade;


import com.example.backend.entity.AttributeDefinition;

import java.util.List;

public interface AttributeDefinitionService {
    com.example.backend.entity.AttributeDefinition findByEntityDefinitionId(Long entityDefinitionId);

    int save(AttributeDefinition attribute);

    List<AttributeDefinition> findAll();
}
