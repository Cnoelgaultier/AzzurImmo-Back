package bts.sio.azurimmo.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class LocataireDTO {

    private Long id;
    private String nom;
    private String prenom;
    private Long tel;
    private String email;
    private Date dateNaissance;
    private String profession;
}

