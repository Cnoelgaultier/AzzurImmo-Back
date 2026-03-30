package bts.sio.azurimmo.model.mapper;

import bts.sio.azurimmo.model.Appartement;
import bts.sio.azurimmo.model.Batiment;
import bts.sio.azurimmo.model.Contrat;
import bts.sio.azurimmo.model.Intervention;
import bts.sio.azurimmo.model.dto.AppartementDTO;

public class AppartementMapper {

    public static AppartementDTO toDTO(Appartement a) {
        if (a == null) return null;

        AppartementDTO dto = new AppartementDTO();
        dto.setNombre(a.getNombre());
        dto.setDescription(a.getDescription());
        dto.setSurface(a.getSurface());
        
        if (a.getBatiment() != null) {
            AppartementDTO.BatimentIdDTO batimentDTO = new AppartementDTO.BatimentIdDTO();
            batimentDTO.setId(a.getBatiment().getId());
            dto.setBatiment(batimentDTO);
        }

        if (a.getContrat() != null) {
            AppartementDTO.ContratIdDTO contratDTO = new AppartementDTO.ContratIdDTO();
            contratDTO.setId(a.getContrat().getId());
            dto.setContrat(contratDTO);
        }


        return dto;
    }

    public static Appartement toEntity(AppartementDTO dto) {
        if (dto == null) return null;

        Appartement a = new Appartement();
        a.setNombre(dto.getNombre());
        a.setDescription(dto.getDescription());
        a.setSurface(dto.getSurface());

        if (dto.getBatiment() != null && dto.getBatiment().getId() != null) {
            Batiment batiment = new Batiment();
            batiment.setId(dto.getBatiment().getId());
            a.setBatiment(batiment);
        }


        if (dto.getContrat() != null && dto.getContrat().getId() != null) {
            Contrat contrat = new Contrat();
            contrat.setId(dto.getContrat().getId());
            a.setContrat(contrat);
        }



        return a;
    }
}