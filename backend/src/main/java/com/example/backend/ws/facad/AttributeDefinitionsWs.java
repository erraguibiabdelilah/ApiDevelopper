package com.example.backend.ws.facad;

import com.example.backend.entity.AttributeDefinition;
import com.example.backend.services.meta.facade.AttributeDefinitionService;
import com.example.backend.ws.convertir.AttributeConvertir;
import com.example.backend.ws.dto.AttributeDefinitionDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/api_backend/attributesDefinitions")
public class AttributeDefinitionsWs {

    private final AttributeDefinitionService attributeDefinitionService;
    private final AttributeConvertir convertir;

    @GetMapping("/entity/{entiy_id}/attribute/{attribute_id}")
    public AttributeDefinitionDto findByIdAndEntityDefinition_Id(@PathVariable Long attribute_id, @PathVariable Long entiy_id) {
        return convertir.toDto(attributeDefinitionService.findByIdAndEntityDefinition_Id(attribute_id, entiy_id));
    }

    @GetMapping("/entity/{entityDefinitionId}/attributeName/{name}")
    public AttributeDefinition findAttributeDefinitionsByNameAndEntityDefinition_Id(@PathVariable String name, @PathVariable Long entityDefinitionId) {
        return attributeDefinitionService.findAttributeDefinitionsByNameAndEntityDefinition_Id(name, entityDefinitionId);
    }

    @GetMapping("/entity/{entityDefinitionId}")
    public List<AttributeDefinitionDto> findAttributeDefinitionsByEntityDefinition_Id(@PathVariable Long entityDefinitionId) {
        return convertir.toDtos(attributeDefinitionService.findAttributeDefinitionsByEntityDefinition_Id(entityDefinitionId));
    }

    @GetMapping("/{id}")
    public AttributeDefinitionDto findAttributeDefinitionsById(@PathVariable Long id) {
        return convertir.toDto(attributeDefinitionService.findAttributeDefinitionsById(id));
    }

    @PostMapping("/")
    public int save(@RequestBody AttributeDefinitionDto attributeDefinitionDto) {
        return attributeDefinitionService.save(attributeDefinitionDto);
    }

    @GetMapping("/")
    public List<AttributeDefinitionDto> findAll() {
        return convertir.toDtos(attributeDefinitionService.findAll());
    }

    public AttributeDefinitionsWs(AttributeDefinitionService attributeDefinitionService,AttributeConvertir convertir) {
        this.attributeDefinitionService = attributeDefinitionService;
        this.convertir=convertir;
    }
}
