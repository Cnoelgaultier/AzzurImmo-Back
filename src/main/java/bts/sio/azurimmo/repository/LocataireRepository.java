package bts.sio.azurimmo.repository;

import bts.sio.azurimmo.model.Locataire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocataireRepository extends JpaRepository<Locataire, Long> {


    @Query("SELECT DISTINCT l FROM Appartement a " +
            "JOIN a.contrat c " +
            "JOIN c.locataire l " +
            "WHERE a.batiment.id = :batimentId")
    List<Locataire> findLocatairesByBatimentId(@Param("batimentId") Long batimentId);

}