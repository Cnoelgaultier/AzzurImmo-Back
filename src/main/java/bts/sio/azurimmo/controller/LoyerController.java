package bts.sio.azurimmo.controller;

import bts.sio.azurimmo.model.dto.LoyerDTO;
import bts.sio.azurimmo.service.LoyerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loyers")
@Tag(name = "Loyers", description = "Gestion des loyers")
public class LoyerController {
    @Autowired
    private LoyerService loyerService;


    @GetMapping
    @Operation(summary = "Récupère tous les loyers")
    public List<LoyerDTO> getAllLoyer() {
        return  loyerService.getAllLoyers();
    }

    @GetMapping("/{loyerId}")
    @Operation(summary = "Récupère un loyer")
    public List<LoyerDTO> getLoyerIds(@PathVariable long loyerId) {
        return loyerService.getLoyerById(loyerId);
    }

    @PostMapping("/")
    @Operation(summary = "Créer un loyer")
    public LoyerDTO saveLoyersDTO(@RequestBody LoyerDTO dto) {
        return loyerService.saveLoyerDTO(dto);
    }


}
