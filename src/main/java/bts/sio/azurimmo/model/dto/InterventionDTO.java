package bts.sio.azurimmo.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class InterventionDTO {

    private Long id;
    private String description;
    private Date date;

    private TypeInterventionIdDTO typeIntervention;

    @Getter
    @Setter
    public static class TypeInterventionIdDTO {
        private Long id;
    }

    private AppartementIdDTO appartement;

    @Getter
    @Setter
    public static class AppartementIdDTO {
        private Long id;
    }
}
