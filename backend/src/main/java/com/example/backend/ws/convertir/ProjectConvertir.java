package com.example.backend.ws.convertir;

import com.example.backend.entity.Project;
import com.example.backend.security.ws.convertir.UserConvertir;
import com.example.backend.ws.dto.ProjectDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ProjectConvertir {

    private final UserConvertir userConvertir;
    private final EntityConvertir entityConvertir;

    ProjectConvertir(UserConvertir convertir , EntityConvertir entityConvertir){
        this.userConvertir=convertir;
        this.entityConvertir=entityConvertir;
    }

    public Project toBean(ProjectDto dto){
        Project bean =new Project();
        bean.setId(dto.getId());
        bean.setProjectName(dto.getProjectName());
        bean.setCreatedAt(dto.getCreatedAt());
        if (dto.getUser()!=null){
            bean.setUser(userConvertir.toBean(dto.getUser()));
        }
        if (dto.getEntitys() != null) {
            bean.setEntitys(entityConvertir.toBeans(dto.getEntitys()));
        }
        return bean;
    }

    public ProjectDto toDto(Project bean){
        ProjectDto dto =new ProjectDto();
        dto.setId(bean.getId());
        dto.setProjectName(bean.getProjectName());
        dto.setCreatedAt(bean.getCreatedAt());
        if (bean.getUser() != null) {
            dto.setUser(userConvertir.toDto(bean.getUser()));
        }
        if(bean.getEntitys()!=null) {
            dto.setEntitys(entityConvertir.toDtos(bean.getEntitys()));
        }
        return dto;
    }

    public List<Project> toBeans(List<ProjectDto> dtos) {
        List<Project> beans = new ArrayList<>();

        for (ProjectDto dto : dtos) {
            Project bean=toBean(dto);
            beans.add(bean);
        }
        return beans;
    }

    public List<ProjectDto> toDtos(List<Project> beans){
        List<ProjectDto> dtos= new ArrayList<>();

        for(Project bean:beans){
            ProjectDto dto=  toDto(bean);
            dtos.add(dto);
        }
        return dtos;
    }

}
