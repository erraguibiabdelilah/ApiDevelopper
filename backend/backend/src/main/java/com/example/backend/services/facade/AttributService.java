package com.example.backend.services.facade;

import com.example.backend.entity.Attribute;

import java.util.List;

public interface AttributService {
    com.example.backend.entity.Attribute findByEntityDefinitionId(Long entityDefinitionId);

    int save(Attribute attribute);

    List<Attribute> findAll();
}
