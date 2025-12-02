package com.example.backend.services.facade;

import com.example.backend.entity.Project;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProjectService {
    List<Project> findByUserId(Long userId);

    boolean existsByProjectNameAndUserId(String projectName, Long userId);

    Project findByIdAndUserId(Long id, Long userId);

    int save(Project project);

    List<Project> findAll();
}
