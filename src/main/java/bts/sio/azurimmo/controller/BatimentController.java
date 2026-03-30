package bts.sio.azurimmo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bts.sio.azurimmo.model.dto.BatimentDTO;
import bts.sio.azurimmo.model.dto.LocataireDTO;
import bts.sio.azurimmo.service.BatimentService;
import bts.sio.azurimmo.service.LocataireService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/batiments")
@Tag(name = "Batiments", description = "Gestion des batiments")
public class BatimentController {

    @Autowired
    private BatimentService batimentService;

    @Autowired
    private LocataireService locataireService;

    @GetMapping("/{batimentId}")
    @Operation(summary = "Récupère un batiment")
    public Optional<BatimentDTO> getBatimentDTO(@PathVariable long batimentId) {
        return batimentService.getBatimentDTO(batimentId);
    }

    @GetMapping
    @Operation(summary = "Récupère tous les batiments")
    public List<BatimentDTO> getAllBatiments() {
        return batimentService.getBatimentsDTO();
    }

    @PostMapping("/")
    @Operation(summary = "Créer un batiment")
    public ResponseEntity<BatimentDTO> createBatiment(@RequestBody BatimentDTO dto) {
        BatimentDTO savedDTO = batimentService.saveBatimentDTO(dto);
        return ResponseEntity.status(201).body(savedDTO);
    }

    @GetMapping("/{batimentId}/locataires")
    @Operation(summary = "Récupère les locataires d'un batiment précis")
    public ResponseEntity<List<LocataireDTO>> getLocatairesByBatiment(@PathVariable long batimentId) {
        List<LocataireDTO> locataires = locataireService.getLocatairesByBatimentId(batimentId);
        return ResponseEntity.ok(locataires);
    }
}