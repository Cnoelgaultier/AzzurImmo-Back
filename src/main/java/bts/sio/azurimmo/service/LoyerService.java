package bts.sio.azurimmo.service;

import bts.sio.azurimmo.model.Loyer;
import bts.sio.azurimmo.model.dto.LoyerDTO;
import bts.sio.azurimmo.model.mapper.LoyerMapper;
import bts.sio.azurimmo.repository.LoyerRepository;
import io.swagger.v3.oas.annotations.Operation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class LoyerService {

     @Autowired
     private LoyerRepository loyerRepository;


    public List<LoyerDTO> getAllLoyers() {
        return loyerRepository.findAll()
                .stream()
                .map(LoyerMapper::toDTO)
                .toList();
    }

    public List<LoyerDTO> getLoyerById(long id) {
        return loyerRepository.findById(id)
                .stream()
                .map(LoyerMapper::toDTO)
                .toList();
    }

    public LoyerDTO saveLoyerDTO(LoyerDTO dto) {
        Loyer entity = LoyerMapper.toEntity(dto);
        Loyer savedEntity = loyerRepository.save(entity);
        return LoyerMapper.toDTO(savedEntity);
    }
}
