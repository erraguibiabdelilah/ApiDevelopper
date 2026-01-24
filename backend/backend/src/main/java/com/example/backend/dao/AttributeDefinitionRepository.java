package com.example.backend.dao;



import com.example.backend.entity.AttributeDefinition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AttributeDefinitionRepository extends JpaRepository<AttributeDefinition, Long> {
    AttributeDefinition findByEntityDefinitionId(Long entityDefinitionId); // Lister les attributs d'une entité
}