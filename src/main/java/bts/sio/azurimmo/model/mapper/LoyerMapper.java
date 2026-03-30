package bts.sio.azurimmo.model.mapper;

import bts.sio.azurimmo.model.Loyer;
import bts.sio.azurimmo.model.dto.LoyerDTO;

public class LoyerMapper {

    public static LoyerDTO toDTO(Loyer loyer) {
        if (loyer == null) {
            return null;
        }

        LoyerDTO dto = new LoyerDTO();
        dto.setSommeTotal(loyer.getSommeTotal());
        dto.setDatePaiement(loyer.getDatePaiement());
        dto.setMois(loyer.getMois());
        dto.setStatusPaiement(loyer.getStatusPaiement());

        return dto;
    }

    public static Loyer toEntity(LoyerDTO dto) {
        if (dto == null) {
            return null;
        }

        Loyer loyer = new Loyer();
        loyer.setSommeTotal(dto.getSommeTotal());
        loyer.setDatePaiement(dto.getDatePaiement());
        loyer.setMois(dto.getMois());
        loyer.setStatusPaiement(dto.getStatusPaiement());

        return loyer;
    }
}