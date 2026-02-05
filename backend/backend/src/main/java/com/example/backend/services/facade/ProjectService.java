package com.example.backend.services.facade;

import com.example.backend.entity.Project;

import java.util.List;
public interface ProjectService {
    Project findProjectById(Long id);

    List<Project> findByUserId(Long userId);

    boolean existsByProjectNameAndUserId(String projectName, Long userId);

    Project findByIdAndUserId(Long id, Long userId);

    int save(Project project);

    int update(Project project);

    List<Project> findAll();

    int deleteById(Long id);
}
