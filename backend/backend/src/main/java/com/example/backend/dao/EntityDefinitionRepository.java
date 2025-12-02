package com.example.backend.dao;


import com.example.backend.entity.EntityDefinition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityDefinitionRepository extends JpaRepository<EntityDefinition, Long> {
    EntityDefinition findByEntityNameAndProjectId(String entityName, Long projectId); // Recherche par nom et projet
    boolean existsByEntityNameAndProjectId(String entityName, Long projectId); // Vérifier l'unicité
    EntityDefinition findByProjectId(Long projectId); // Lister les entités d'un projet
}
