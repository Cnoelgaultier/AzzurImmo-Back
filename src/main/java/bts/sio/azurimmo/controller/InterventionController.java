package bts.sio.azurimmo.controller;


import bts.sio.azurimmo.model.dto.InterventionDTO;
import bts.sio.azurimmo.service.InterventionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/interventions")
@Tag(name = "Interventions", description = "Gestion des interventions")
public class InterventionController {

    @Autowired
    private InterventionService interventionService;

    @GetMapping
    @Operation(summary = "Lister toute les interventions")
    public List<InterventionDTO> getAllInterventions() {
        return interventionService.getAllInterventions();
    }

    @GetMapping("/{interventionId}")
    @Operation(summary = "Récupére une intervention selon un ID")
    public InterventionDTO getInterventionById(@PathVariable long interventionId) {
        return interventionService.getInterventionDTO(interventionId).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Intervention introuvable"
        ));
    }

    @PostMapping("/")
    @Operation(summary = "Créer une intervention")
    public InterventionDTO createIntervention(@RequestBody InterventionDTO dto) {
        return interventionService.saveIntervention(dto);
    }

}
