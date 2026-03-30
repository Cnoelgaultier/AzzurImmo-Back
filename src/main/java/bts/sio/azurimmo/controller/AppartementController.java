package bts.sio.azurimmo.controller;

import bts.sio.azurimmo.model.Appartement;
import bts.sio.azurimmo.model.dto.AppartementDTO;
import bts.sio.azurimmo.service.AppartementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/appartements")
@Tag(name = "Appartements", description = "Gestion des appartements")
public class AppartementController {
	
   @Autowired
    private AppartementService appartementService;

	
    @PostMapping("/")
    @Operation(summary = "Créer un appartement")
    public AppartementDTO createAppartement(@RequestBody AppartementDTO appartement) {
        return appartementService.saveAppartement(appartement);
    }

    @GetMapping
    @Operation(summary = "Récupère tous les appartements")
    public List<AppartementDTO> getAllAppartements() {
        return appartementService.getAllAppartements();
    }
    
    @GetMapping("/ville/{ville}")
    @Operation(summary = "Trier les appartements par ville")
    public List<AppartementDTO> findByVille(@PathVariable String ville) {
        return appartementService.findByVille(ville);
    }
    
    @GetMapping("/batiment/{batimentId}")
    @Operation(summary = "Récupère tous les appartements selon l'id d'un batiment")
    public List<AppartementDTO> getAppartementsParBatiment(@PathVariable long batimentId) {
            return appartementService.getAppartementsParBatiment(batimentId);
     }
    
    @GetMapping("/surface/{surface}")
    @Operation(summary = "Récupère tous les appartements ayant une surface supérieure à la surface définie")
    public List<AppartementDTO> getSurfaceGreaterThan(@PathVariable long surface) {
        return appartementService.getSurfaceGreaterThan(surface);
    }

    
    

}