package bts.sio.azurimmo.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class LoyerDTO {

    private String sommeTotal;
    private Date datePaiement;
    private String mois;
    private String statusPaiement;
    private String modePaiement;
}
