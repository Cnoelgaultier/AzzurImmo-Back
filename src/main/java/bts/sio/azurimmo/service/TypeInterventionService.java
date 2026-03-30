package bts.sio.azurimmo.service;

import bts.sio.azurimmo.model.Intervention;
import bts.sio.azurimmo.model.TypeIntervention;
import bts.sio.azurimmo.model.dto.InterventionDTO;
import bts.sio.azurimmo.model.dto.TypeInterventionDTO;
import bts.sio.azurimmo.model.mapper.InterventionMapper;
import bts.sio.azurimmo.model.mapper.TypeInterventionMapper;
import bts.sio.azurimmo.repository.TypeInterventionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TypeInterventionService {
    @Autowired
    private TypeInterventionRepository typeInterventionRepository;

    public List<TypeInterventionDTO> getAllTypeInterventions() {
        return typeInterventionRepository.findAll()
                .stream()
                .map(TypeInterventionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<TypeInterventionDTO> getTypeInterventionById(Long id) {
        return typeInterventionRepository.findById(Math.toIntExact(id))
                .map(TypeInterventionMapper::toDTO);
    }

    public TypeInterventionDTO saveTypeIntervention(TypeInterventionDTO dto) {

        TypeIntervention entity = TypeInterventionMapper.toEntity(dto);

        TypeIntervention saved = typeInterventionRepository.save(entity);

        return TypeInterventionMapper.toDTO(saved);
    }
}
