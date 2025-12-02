package com.example.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private boolean required;
    private String enumValues;

    @ManyToOne
    @JoinColumn(name = "entity_id")
    private EntityDefinition entityDefinition;
}