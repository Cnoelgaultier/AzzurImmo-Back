package bts.sio.azurimmo.model.mapper;

import bts.sio.azurimmo.model.Intervention;
import bts.sio.azurimmo.model.TypeIntervention;
import bts.sio.azurimmo.model.dto.InterventionDTO;

import java.util.stream.Collectors;

public class InterventionMapper {

    public static InterventionDTO toDTO(Intervention i) {
        if (i == null) return null;

        InterventionDTO dto = new InterventionDTO();
        dto.setId(i.getId());
        dto.setDescription(i.getDescription());
        dto.setDate(i.getDate());

        if (i.getTypeIntervention() != null) {
            InterventionDTO.TypeInterventionIdDTO typeInterventionDTO = new InterventionDTO.TypeInterventionIdDTO();
            typeInterventionDTO.setId((long) i.getTypeIntervention().getId());
            dto.setTypeIntervention(typeInterventionDTO);
        }

        if (i.getAppartement() != null) {
            InterventionDTO.AppartementIdDTO appartementDTO = new InterventionDTO.AppartementIdDTO();
            appartementDTO.setId(i.getAppartement().getNumero());
            dto.setAppartement(appartementDTO);
        }
        return dto;

    }

    public static Intervention toEntity(InterventionDTO dto) {
        if (dto == null) return null;

        Intervention intervention = new Intervention();
        intervention.setDescription(dto.getDescription());
        intervention.setDate(dto.getDate());
        if (dto.getTypeIntervention() != null && dto.getTypeIntervention().getId() != null) {
            TypeIntervention typeIntervention = new TypeIntervention();
            typeIntervention.setId(Math.toIntExact(dto.getTypeIntervention().getId()));
            intervention.setTypeIntervention(typeIntervention);

        }

        return intervention;

    }

}
