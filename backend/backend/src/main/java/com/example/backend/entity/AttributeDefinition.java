package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "attribute_definition")
public class AttributeDefinition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AttributeType type;

    @Column(nullable = false)
    private boolean required;

    // Contraintes
    private Integer length;
    private Boolean uniqueField;
    private String defaultValue;

    // ENUM uniquement
    @ElementCollection
    @CollectionTable(
            name = "attribute_enum_values",
            joinColumns = @JoinColumn(name = "attribute_id")
    )
    @Column(name = "value")
    private List<String> enumValues;

    @ManyToOne

    @JoinColumn(name = "entity_id", nullable = false)
    private EntityDefinition entityDefinition;
}
