package bts.sio.azurimmo.controller;

import bts.sio.azurimmo.model.dto.ContratDTO;
import bts.sio.azurimmo.service.ContratService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contrats")
@Tag(name = "Contrats", description = "Gestion des contrats")
public class ContratController {

    @Autowired
    private ContratService contratService;


    @GetMapping
    @Operation(summary = "Récupère tous les contrats")
    public List<ContratDTO> getAllContrats() {
        return contratService.getAllContrat();
    }

    @GetMapping("/{contratID}")
    @Operation(summary = "Récupère un contrat")
    public Optional<ContratDTO> getContratById(@PathVariable long contratID) {
        return contratService.getContratById(contratID);
    }

    @PostMapping("/")
    @Operation(summary = "Créer un contrat")
    public ResponseEntity<ContratDTO> saveContrats(@RequestBody ContratDTO dto) {
        ContratDTO contratDTO = contratService.saveContrat(dto);
        return ResponseEntity.status(201).body(contratDTO);
    }
}
