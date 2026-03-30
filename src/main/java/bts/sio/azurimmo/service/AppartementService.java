package bts.sio.azurimmo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bts.sio.azurimmo.model.Appartement;
import bts.sio.azurimmo.model.Batiment;
import bts.sio.azurimmo.model.dto.AppartementDTO;
import bts.sio.azurimmo.repository.AppartementRepository;
import bts.sio.azurimmo.repository.BatimentRepository;
import bts.sio.azurimmo.model.mapper.AppartementMapper;
import lombok.Data;

@Data
@Service
public class AppartementService {

    @Autowired
    private AppartementRepository appartementRepository;
    
    @Autowired
    private BatimentRepository batimentRepository;

    public AppartementDTO saveAppartement(AppartementDTO dto) {
        Appartement entity = AppartementMapper.toEntity(dto);
        

        if (dto.getBatiment() != null && dto.getBatiment().getId() != null) {
            try {
                Batiment batiment = batimentRepository.getReferenceById(dto.getBatiment().getId());
                entity.setBatiment(batiment);
            } catch (Exception e) {
                throw new RuntimeException("Bâtiment non trouvé avec l'ID: " + dto.getBatiment().getId());
            }
        }
        
        Appartement saved = appartementRepository.save(entity);
        return AppartementMapper.toDTO(saved);
    }

    public List<AppartementDTO> findByVille(String ville) {
        return appartementRepository.findByBatiment_Ville(ville)
            .stream()
            .map(AppartementMapper::toDTO)
            .toList();
    }

    public List<AppartementDTO> getAllAppartements() {
        return appartementRepository.findAll()
            .stream()
            .map(AppartementMapper::toDTO)
            .toList();
    }

    public List<AppartementDTO> getAppartementsParBatiment(long id) {
        return appartementRepository.findByBatiment_Id(id)
            .stream()
            .map(AppartementMapper::toDTO)
            .toList();
    }


    public List<AppartementDTO> getSurfaceGreaterThan(long surface) {
        return appartementRepository.findBySurfaceGreaterThan(surface)
            .stream()
            .map(AppartementMapper::toDTO)
            .toList();
    }
}