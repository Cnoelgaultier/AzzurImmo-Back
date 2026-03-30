package bts.sio.azurimmo.service;

import bts.sio.azurimmo.model.Contrat;
import bts.sio.azurimmo.model.Loyer;
import bts.sio.azurimmo.model.dto.ContratDTO;
import bts.sio.azurimmo.model.mapper.ContratMapper;
import bts.sio.azurimmo.repository.ContratRepository;
import bts.sio.azurimmo.repository.LoyerRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class ContratService {

    @Autowired
    private ContratRepository contratRepository;

    @Autowired
    private LoyerRepository loyerRepository;

    public List<ContratDTO> getAllContrat() {
        return contratRepository.findAll()
                .stream()
                .map(ContratMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ContratDTO> getContratById(Long id) {
        return contratRepository.findById(id)
                .map(ContratMapper::toDTO);
    }

    public ContratDTO saveContrat(ContratDTO contratDTO) {
        Contrat contrat = ContratMapper.toEntity(contratDTO);

        if (contrat.getLoyer() != null && contrat.getLoyer().getId() != null) {
            try {
                Loyer loyer = loyerRepository.getReferenceById(contratDTO.getLoyer().getId());
                contrat.setLoyer(loyer);
            } catch (Exception e) {
                throw new RuntimeException("Contrat non trouvé");
            }

        }
        Contrat savedContrat = contratRepository.save(contrat);
        return ContratMapper.toDTO(savedContrat);
    }
}
