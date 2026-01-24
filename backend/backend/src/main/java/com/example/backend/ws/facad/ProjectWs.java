package com.example.backend.ws.facad;

import com.example.backend.entity.Project;
import com.example.backend.services.facade.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/api_backend/projects")
public class ProjectWs {

    private final ProjectService projectService;
    @GetMapping("/{id}")
    public Project findProjectById(@PathVariable Long id) {
        return projectService.findProjectById(id);
    }
    @PutMapping("/")
    public int update(@RequestBody Project project) {
        return projectService.update(project);
    }
    @GetMapping("/user/{userId}")
    public List<Project> findByUserId(@PathVariable Long userId) {
        return projectService.findByUserId(userId);
    }
    @GetMapping("/user/{userId}/project/{projectName}")
    public boolean existsByProjectNameAndUserId(@PathVariable String projectName,@PathVariable Long userId) {
        return projectService.existsByProjectNameAndUserId(projectName, userId);
    }
    @GetMapping("/user/{userId}/project/{id}")
    public Project findByIdAndUserId(@PathVariable Long id,@PathVariable Long userId) {
        return projectService.findByIdAndUserId(id, userId);
    }
    @PostMapping("/")
    public int save(@RequestBody Project project) {
        return projectService.save(project);
    }
    @GetMapping("/")
    public List<Project> findAll() {
        return projectService.findAll();
    }

    public ProjectWs(ProjectService projectService) {
        this.projectService = projectService;
    }
}
