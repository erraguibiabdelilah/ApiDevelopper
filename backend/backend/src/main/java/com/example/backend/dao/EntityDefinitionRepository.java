package com.example.backend.dao;


import com.example.backend.entity.EntityDefinition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityDefinitionRepository extends JpaRepository<EntityDefinition, Long> {
    EntityDefinition findByEntityNameAndProjectId(String entityName, Long projectId);
    boolean existsByEntityNameAndProjectId(String entityName, Long projectId);
    EntityDefinition findByProjectId(Long projectId);
}
