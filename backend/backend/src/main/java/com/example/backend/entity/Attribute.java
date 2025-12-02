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
    private String type; // Ex. : "String", "Number", "Enum"
    private boolean required;
    private String enumValues; // Pour les types Enum, stocke les valeurs possibles (ex. : "todo,done")

    @ManyToOne
    @JoinColumn(name = "entity_definition_id")
    private EntityDefinition entityDefinition;
}