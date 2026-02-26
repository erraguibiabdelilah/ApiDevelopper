package com.example.backend.dao;


import com.example.backend.entity.EntityDefinition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntityDefinitionRepository extends JpaRepository<EntityDefinition, Long> {
    EntityDefinition findEntityDefinitionById(Long id);
    EntityDefinition findByEntityNameAndProjectId(String entityName, Long projectId);
    boolean existsByEntityNameAndProjectId(String entityName, Long projectId);
    List<EntityDefinition> findByProjectId(Long projectId);
}
