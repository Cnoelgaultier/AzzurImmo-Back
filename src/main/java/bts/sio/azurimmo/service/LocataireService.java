package bts.sio.azurimmo.service;

import bts.sio.azurimmo.model.Locataire;
import bts.sio.azurimmo.model.dto.LocataireDTO;
import bts.sio.azurimmo.repository.LocataireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocataireService {

    @Autowired
    private LocataireRepository locataireRepository;

    public List<LocataireDTO> getLocatairesByBatimentId(Long batimentId) {
        List<Locataire> locataires = locataireRepository.findLocatairesByBatimentId(batimentId);

        return locataires.stream().map(locataire -> {
            LocataireDTO dto = new LocataireDTO();
            dto.setId(locataire.getId());
            dto.setNom(locataire.getNom());
            dto.setPrenom(locataire.getPrenom());
            dto.setEmail(locataire.getEmail());
            dto.setTel(locataire.getTel());
            return dto;
        }).collect(Collectors.toList());
    }
}