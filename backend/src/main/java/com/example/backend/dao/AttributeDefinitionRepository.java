package com.example.backend.dao;



import com.example.backend.entity.AttributeDefinition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AttributeDefinitionRepository extends JpaRepository<AttributeDefinition, Long> {

    AttributeDefinition findAttributeDefinitionsById(Long id);

    List<AttributeDefinition> findAttributeDefinitionsByEntityDefinition_Id(Long entityDefinitionId);

    AttributeDefinition findByIdAndEntityDefinition_Id(Long attribute_id,Long entiy_id);

    AttributeDefinition findAttributeDefinitionsByNameAndEntityDefinition_Id(String name, Long entityDefinitionId);



}