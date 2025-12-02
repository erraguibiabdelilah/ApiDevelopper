package com.example.backend.entity;

import com.example.backend.security.bean.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
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

    @OneToMany
    private List<EntityDefinition> entity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}