package bts.sio.azurimmo.model.mapper;

import bts.sio.azurimmo.model.Contrat;
import bts.sio.azurimmo.model.Loyer;
import bts.sio.azurimmo.model.dto.ContratDTO;
import bts.sio.azurimmo.model.dto.LoyerDTO;

public class ContratMapper {

    public static ContratDTO toDTO(Contrat contrat) {
        if (contrat == null) {
            return null;
        }
        ContratDTO contratDTO = new ContratDTO();
        contratDTO.setDateDebut(contrat.getDateDebut());
        contratDTO.setDateFin(contrat.getDateFin());
        contratDTO.setStatut(contrat.getStatut());
        contratDTO.setTypeContrat(contrat.getTypeContrat());

        if (contrat.getLoyer() != null) {
            ContratDTO.LoyerDTO loyerDTO = new ContratDTO.LoyerDTO();
            loyerDTO.setId(contrat.getLoyer().getId());
            contratDTO.setLoyer(loyerDTO);
        }

        return contratDTO;
    }

    public static Contrat toEntity(ContratDTO contratDTO) {
        if (contratDTO == null) {
            return null;
        }

        Contrat contrat = new Contrat();
        contrat.setDateDebut(contratDTO.getDateDebut());
        contrat.setDateFin(contratDTO.getDateFin());
        contrat.setStatut(contratDTO.getStatut());
        contrat.setTypeContrat(contratDTO.getTypeContrat());

        if (contratDTO.getLoyer() != null) {
            Loyer loyer = new Loyer();
            loyer.setId(contratDTO.getLoyer().getId());
            contrat.setLoyer(loyer);
        }
        return contrat;
    }
}
