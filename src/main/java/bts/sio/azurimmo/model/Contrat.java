package bts.sio.azurimmo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "Contrat")
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dateDebut")
    private Date dateDebut;

    @Column(name = "dateFin")
    private Date dateFin;

    @Column(name = "statut")
    private String statut;

    @Column(name = "typeContrat")
    private String typeContrat;

    @ManyToOne
    @JoinColumn(name = "idLoyer")
    private Loyer loyer;


}
