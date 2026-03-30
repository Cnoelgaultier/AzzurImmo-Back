package bts.sio.azurimmo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "Locataire")
public class Locataire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "tel")
    private Long tel;

    @Column(name = "email")
    private String email;

    @Column(name = "dateNaissance")
    private Date dateNaissance;

    @Column(name = "profession")
    private String profession;


}
