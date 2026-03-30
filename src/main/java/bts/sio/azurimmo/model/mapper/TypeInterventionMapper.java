package bts.sio.azurimmo.model.mapper;

import bts.sio.azurimmo.model.TypeIntervention;
import bts.sio.azurimmo.model.dto.TypeInterventionDTO;

import java.util.stream.Collectors;

public class TypeInterventionMapper {

    public static TypeInterventionDTO toDTO(TypeIntervention typeIntervention) {
        if (typeIntervention == null) return null;

        TypeInterventionDTO typeInterventionDTO = new TypeInterventionDTO();
        typeInterventionDTO.setLibelle(typeIntervention.getLibelle());

        return typeInterventionDTO;
    }

    public static TypeIntervention toEntity(TypeInterventionDTO typeInterventionDTO) {
        if  (typeInterventionDTO == null) return null;

        TypeIntervention typeIntervention = new TypeIntervention();
        typeIntervention.setLibelle(typeInterventionDTO.getLibelle());


        return typeIntervention;
    }
}
