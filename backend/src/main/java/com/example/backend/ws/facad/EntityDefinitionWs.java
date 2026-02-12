package com.example.backend.ws.facad;

import com.example.backend.entity.EntityDefinition;
import com.example.backend.services.facade.EntityDefinitionServices;
import com.example.backend.ws.convertir.EntityConvertir;
import com.example.backend.ws.dto.EntityDefinitionDto;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/api_backend/entityDefinitions")
public class EntityDefinitionWs {

    private final EntityDefinitionServices services;
    private final EntityConvertir convertir;
    public EntityDefinitionWs(EntityDefinitionServices services , EntityConvertir convertir) {
        this.services = services;
        this.convertir=convertir;
    }

    @GetMapping("/{id}")
    public EntityDefinitionDto findEntityDefinitionById(@PathVariable Long id) {
        return convertir.toDto(services.findEntityDefinitionById(id));
    }

    @GetMapping("/project/{projectId}/entityDefinitions/{entityName}")
    public EntityDefinitionDto findByEntityNameAndProjectId(@PathVariable String entityName, @PathVariable  Long projectId) {
        return convertir.toDto(services.findByEntityNameAndProjectId(entityName, projectId));
    }
    @GetMapping("/project/{projectId}")
    public List<EntityDefinitionDto> findByProjectId(@PathVariable Long projectId) {
        return convertir.toDtos(services.findByProjectId(projectId));
    }
    @PostMapping("/")
    public int save(@RequestBody EntityDefinitionDto entityDefinitionDto) {
        EntityDefinition entityDefinition=convertir.toBean(entityDefinitionDto);
        return services.save(entityDefinition);
    }

    @PutMapping("/")
    public int update(@RequestBody EntityDefinitionDto entityDefinitionDto) {
        EntityDefinition entityDefinition=convertir.toBean(entityDefinitionDto);
        return services.update(entityDefinition);
    }

    @GetMapping("/")
    public List<EntityDefinitionDto> findAll() {
        return convertir.toDtos(services.findAll());
    }

    @DeleteMapping("/{id}") @Transactional
    public int deleteById(@PathVariable Long id) {
        return services.deleteById(id);}


}
