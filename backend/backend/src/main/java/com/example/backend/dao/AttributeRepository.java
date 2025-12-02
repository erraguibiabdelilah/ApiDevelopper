package com.example.backend.dao;


import com.example.backend.entity.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AttributeRepository extends JpaRepository<Attribute, Long> {
    Attribute findByEntityDefinitionId(Long entityDefinitionId); // Lister les attributs d'une entité
}