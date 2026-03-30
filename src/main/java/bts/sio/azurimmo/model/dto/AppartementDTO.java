package bts.sio.azurimmo.model.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppartementDTO {
	 private String description;
	 private Long nombre;
	 private Long surface;
	 private BatimentIdDTO batiment;
	    
	    @Getter
	    @Setter
	    public static class BatimentIdDTO {
	        private Long id;
	    }

	 private ContratIdDTO contrat;

		 @Getter
		 @Setter
		 public static class ContratIdDTO {
				private Long id;
		 }
}