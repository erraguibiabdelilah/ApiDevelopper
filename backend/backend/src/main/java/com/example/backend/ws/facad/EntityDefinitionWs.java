package com.example.backend.ws.facad;

import com.example.backend.entity.EntityDefinition;
import com.example.backend.services.facade.EntityDefinitionServices;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/api_backend/entityDefinitions")
public class EntityDefinitionWs {

    private final EntityDefinitionServices services;

    @GetMapping("/{id}")
    public EntityDefinition findEntityDefinitionById(@PathVariable Long id) {
        return services.findEntityDefinitionById(id);
    }

    @GetMapping("/project/{projectId}/entityDefinitions/{entityName}")
    public EntityDefinition findByEntityNameAndProjectId(@PathVariable String entityName, @PathVariable  Long projectId) {
        return services.findByEntityNameAndProjectId(entityName, projectId);
    }
    @GetMapping("/project/{projectId}")
    public List<EntityDefinition> findByProjectId(@PathVariable Long projectId) {
        return services.findByProjectId(projectId);
    }
    @PostMapping("/")
    public int save(@RequestBody EntityDefinition entityDefinition) {
        return services.save(entityDefinition);
    }

    @PutMapping("/")
    public int update(@RequestBody EntityDefinition entityDefinition) {
        return services.update(entityDefinition);
    }

    @GetMapping("/")
    public List<EntityDefinition> findAll() {
        return services.findAll();
    }

    @DeleteMapping("/{id}") @Transactional
    public int deleteById(@PathVariable Long id) {return services.deleteById(id);}

    public EntityDefinitionWs(EntityDefinitionServices services) {
        this.services = services;
    }
}
