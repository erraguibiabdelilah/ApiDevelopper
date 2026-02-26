package com.example.backend.ws.meta.facad;

import com.example.backend.entity.Project;
import com.example.backend.services.meta.facade.ProjectService;
import com.example.backend.ws.meta.convertir.ProjectConvertir;
import com.example.backend.ws.meta.dto.ProjectDto;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/api_backend/projects")
public class ProjectWs {

    private final ProjectService projectService;
    private final ProjectConvertir convertir;
    public ProjectWs(ProjectService projectService, ProjectConvertir convertir) {
        this.projectService = projectService;
        this.convertir = convertir;
    }


    @GetMapping("/{id}")
    public ProjectDto findProjectById(@PathVariable Long id) {

        return convertir.toDto(projectService.findProjectById(id));
    }

    @PutMapping("/")
    public int update(@RequestBody ProjectDto projectDto) {
        Project project=convertir.toBean(projectDto);
        return projectService.update(project);
    }

    @GetMapping("/user/{userId}")
    public List<ProjectDto> findByUserId(@PathVariable Long userId) {
        return convertir.toDtos(projectService.findByUserId(userId));
    }

    @GetMapping("/user/{userId}/project/{id}")
    public ProjectDto findByIdAndUserId(@PathVariable Long id, @PathVariable Long userId) {
        return convertir.toDto(projectService.findByIdAndUserId(id, userId));
    }

    @PostMapping("/")
    public int save(@RequestBody ProjectDto projectDto) {
        Project project=convertir.toBean(projectDto);
        return projectService.save(project);
    }


    @GetMapping("/")
    public List<ProjectDto> findAll() {
       return convertir.toDtos(projectService.findAll());
    }



    @Transactional
    @DeleteMapping("/{id}")
    public int deleteById(@PathVariable Long id) {
        return projectService.deleteById(id);
    }
/*
    @GetMapping("/entitys/user/{id}")
    public List<Project> findProjectsWithEntitiesByUserId(@PathVariable Long id ) {
        return projectService.findProjectsWithEntitiesByUserId(id);
    }*/

}
