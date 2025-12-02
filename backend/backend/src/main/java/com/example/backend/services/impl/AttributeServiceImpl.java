package com.example.backend.services.impl;

import com.example.backend.dao.AttributeRepository;
import com.example.backend.entity.Attribute;
import com.example.backend.services.facade.AttributService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AttributeServiceImpl implements AttributService {

    @Autowired
    AttributeRepository dao;
    @Override
    public Attribute findByEntityDefinitionId(Long entityDefinitionId) {
        return dao.findByEntityDefinitionId(entityDefinitionId);
    }
    @Override
    public int save(Attribute attribute) {
        dao.save(attribute);
        return 1;
    }
    @Override
    public List<Attribute> findAll() {
        return dao.findAll();
    }
}
