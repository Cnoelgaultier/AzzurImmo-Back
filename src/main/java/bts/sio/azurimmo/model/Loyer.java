package bts.sio.azurimmo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "Loyer")
public class Loyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sommeTotal")
    private String sommeTotal;

    @Column(name = "datePaiement")
    private Date datePaiement;

    @Column(name = "mois")
    private String mois;

    @Column(name = "statusPaiement")
    private String statusPaiement;

    @Column(name = "modePaiement")
    private String modePaiement;


}
