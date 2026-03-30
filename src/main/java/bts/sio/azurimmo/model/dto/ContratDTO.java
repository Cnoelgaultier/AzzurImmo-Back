package bts.sio.azurimmo.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class ContratDTO {
    private Date dateDebut;
    private Date dateFin;
    private String statut;
    private String typeContrat;

    private LoyerDTO loyer;

    @Getter
    @Setter
    public static class LoyerDTO {
        private Long id;
    }


}
