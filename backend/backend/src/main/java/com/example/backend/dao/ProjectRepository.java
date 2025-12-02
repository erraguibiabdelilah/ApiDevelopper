package com.example.backend.dao;
import com.example.backend.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    Project findByIdAndUserId(Long id, Long userId);
    boolean existsByProjectNameAndUserId(String projectName, Long userId);
    List<Project> findByUserId(Long userId);
}