package com.example.backend.entity;

import com.example.backend.security.bean.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String projectName;
    private LocalDateTime createdAt;
    @Column(nullable = false)

    @OneToMany(mappedBy = "project",cascade = CascadeType.ALL)
    private List<EntityDefinition> entitys=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}