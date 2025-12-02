package com.example.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class EntityDefinition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String entityName;
    @OneToMany
    private List<Attribute> attributes;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
}