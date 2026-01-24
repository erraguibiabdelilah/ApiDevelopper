package com.example.backend.services.impl;

import com.example.backend.dao.ProjectRepository;
import com.example.backend.entity.Project;
import com.example.backend.services.facade.ProjectService;

import java.util.List;
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository dao;

    @Override
    public Project findProjectById(Long id) {
        return dao.findProjectById(id);
    }

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
        boolean sameName= existsByProjectNameAndUserId(project.getProjectName(),project.getUser().getId());
        if (project.getProjectName() ==null) return -1;
        if (project.getUser() ==null) return -2;
        if (sameName) return -3;
        dao.save(project);
        return 1;
    }

    @Override
    public int update(Project project){
        Project oldProject =findProjectById(project.getId());
        if (oldProject==null) return -1 ;
        oldProject.setProjectName(project.getProjectName());

        dao.save(oldProject);
        return 1;

    }
    @Override
    public List<Project> findAll() {
        return dao.findAll();
    }





    ProjectServiceImpl(ProjectRepository dao){
        this.dao=dao;
    }
}
