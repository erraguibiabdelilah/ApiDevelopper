package com.example.backend.ws.facad;

import com.example.backend.entity.AttributeDefinition;
import com.example.backend.services.facade.AttributeDefinitionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/api_backend/attributesDefinitions")
public class AttributeDefinitionsWs {

    private final AttributeDefinitionService  attributeDefinitionService;

    @GetMapping("/entity/{entiy_id}/attribute/{attribute_id}")
    public AttributeDefinition findByIdAndEntityDefinition_Id(@PathVariable Long attribute_id,@PathVariable Long entiy_id) {
        return attributeDefinitionService.findByIdAndEntityDefinition_Id(attribute_id, entiy_id);
    }
    @GetMapping("/entity/{entityDefinitionId}/attributeName/{name}")
    public AttributeDefinition findAttributeDefinitionsByNameAndEntityDefinition_Id(@PathVariable String name,@PathVariable Long entityDefinitionId) {
        return attributeDefinitionService.findAttributeDefinitionsByNameAndEntityDefinition_Id(name, entityDefinitionId);
    }
    @GetMapping("/entity/{entityDefinitionId}")
    public List<AttributeDefinition> findAttributeDefinitionsByEntityDefinition_Id(@PathVariable Long entityDefinitionId) {
        return attributeDefinitionService.findAttributeDefinitionsByEntityDefinition_Id(entityDefinitionId);
    }
    @GetMapping("/{id}")
    public AttributeDefinition findAttributeDefinitionsById(@PathVariable Long id) {
        return attributeDefinitionService.findAttributeDefinitionsById(id);
    }
    @PostMapping("/")
    public int save(@RequestBody AttributeDefinition attribute) {
        return attributeDefinitionService.save(attribute);
    }

    @GetMapping("/")
    public List<AttributeDefinition> findAll() {

        return attributeDefinitionService.findAll();
    }

    public AttributeDefinitionsWs(AttributeDefinitionService attributeDefinitionService) {
        this.attributeDefinitionService = attributeDefinitionService;
    }
}
