package bts.sio.azurimmo.repository;

import bts.sio.azurimmo.model.Contrat;
import bts.sio.azurimmo.model.Intervention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Long> {
}
