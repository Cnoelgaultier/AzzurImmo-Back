package bts.sio.azurimmo.service;

import bts.sio.azurimmo.model.Intervention;
import bts.sio.azurimmo.model.TypeIntervention;
import bts.sio.azurimmo.model.dto.InterventionDTO;
import bts.sio.azurimmo.model.mapper.InterventionMapper;
import bts.sio.azurimmo.repository.InterventionRepository;
import bts.sio.azurimmo.repository.TypeInterventionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InterventionService {
    @Autowired
    private InterventionRepository interventionRepository;

    @Autowired
    private TypeInterventionRepository typeInterventionRepository;


    public List<InterventionDTO> getAllInterventions() {
        return interventionRepository.findAll().stream().map(InterventionMapper::toDTO).collect(Collectors.toList());
    }

    public Optional<InterventionDTO> getInterventionDTO(Long id) {
        return interventionRepository.findById(id)
                .map(InterventionMapper::toDTO);
    }

    public InterventionDTO saveIntervention(InterventionDTO dto) {
        Intervention entity = InterventionMapper.toEntity(dto);

        if (dto.getTypeIntervention() != null && dto.getTypeIntervention().getId() != null) {
            try {
                TypeIntervention TypeIntervention = typeInterventionRepository.getReferenceById(entity.getTypeIntervention().getId());
                entity.setTypeIntervention(TypeIntervention);
            } catch (Exception e) {
                throw new RuntimeException("Type d'intervention n'existe pas ave l'ID: " + dto.getTypeIntervention().getId());
            }
        }

        Intervention saved= interventionRepository.save(entity);
        return InterventionMapper.toDTO(saved);
    }



}
