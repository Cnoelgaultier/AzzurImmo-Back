package bts.sio.azurimmo.controller;

import bts.sio.azurimmo.model.dto.TypeInterventionDTO;
import bts.sio.azurimmo.repository.TypeInterventionRepository;
import bts.sio.azurimmo.service.TypeInterventionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/typeInterventions")
@Tag(name = "TypeInterventions", description = "Gestion des types d'interventions")
public class TypeInterventionController {

    @Autowired
    private TypeInterventionService typeInterventionService;

    @GetMapping
    @Operation(summary = "Récupère tous les types d'interventions")
    public List<TypeInterventionDTO> getallTypeInterventions() {
        return typeInterventionService.getAllTypeInterventions();
    }

    @GetMapping("/{typeInterventionId}")
    @Operation(summary = "Récupère un type d'intervention selon un id")
    public TypeInterventionDTO getTypeInterventionById(@PathVariable long typeInterventionId) {
        return typeInterventionService.getTypeInterventionById(typeInterventionId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Type d'intervention introuvable"
                ));
    }

    @PostMapping("/")
    @Operation(summary = "Créer un type d'intervention")
    public TypeInterventionDTO createTypeIntervention(@RequestBody TypeInterventionDTO dto) {
        return typeInterventionService.saveTypeIntervention(dto);
    }


}
