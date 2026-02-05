package com.example.backend.services.impl;

import com.example.backend.dao.ProjectRepository;
import com.example.backend.entity.Project;
import com.example.backend.security.bean.User;
import com.example.backend.security.services.utils.SecurityUtils;
import com.example.backend.services.facade.ProjectService;

import org.springframework.stereotype.Service;

import java.util.List;
@Service

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
        User user = SecurityUtils.getCurrentUser();
       // boolean sameName= existsByProjectNameAndUserId(project.getProjectName(),project.getUser().getId());
        if (user==null) return -3;
        project.setUser(user);
        if (project.getProjectName() ==null) return -1;
        //if (sameName) return -3;
        dao.save(project);
        return 1;
    }

    @Override
    public int update(Project project){
        if (project.getId() == null) return -1;
        User user=SecurityUtils.getCurrentUser();
        if (user ==null) return -2;
        Project oldProject=findByIdAndUserId(project.getId(),user.getId());
        if (oldProject==null) return -3 ;
        oldProject.setProjectName(project.getProjectName());
        dao.save(oldProject);
        return 1;
    }
    @Override
    public List<Project> findAll() {
        return dao.findAll();
    }
    @Override
    public int deleteById(Long id) {
        dao.deleteById(id);
        return 1;
    }

    ProjectServiceImpl(ProjectRepository dao){
        this.dao=dao;
    }
}
