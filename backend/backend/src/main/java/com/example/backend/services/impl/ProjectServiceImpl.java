package com.example.backend.services.impl;

import com.example.backend.dao.ProjectRepository;
import com.example.backend.entity.Project;
import com.example.backend.services.facade.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectRepository dao;

    @Override
    public List<Project> findByUserId(Long userId) {
        return dao.findByUserId(userId);
    }
    @Override
    public boolean existsByProjectNameAndUserId(String projectName, Long userId) {
        return dao.existsByProjectNameAndUserId(projectName, userId);
    }
    @Override
    public Project findByIdAndUserId(Long id, Long userId) {
        return dao.findByIdAndUserId(id, userId);
    }
    @Override
    public int save(Project project) {
        dao.save(project);
        return 1;
    }
    @Override
    public List<Project> findAll() {
        return dao.findAll();
    }
}
