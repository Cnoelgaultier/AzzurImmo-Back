package bts.sio.azurimmo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Intervention")
public class Intervention {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "idTypeIntervention")
    private TypeIntervention typeIntervention;

    @ManyToOne
    @JoinColumn(name = "idAppartement")
    private Appartement appartement;


}
