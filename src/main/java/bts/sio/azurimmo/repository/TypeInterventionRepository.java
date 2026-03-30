package bts.sio.azurimmo.repository;

import bts.sio.azurimmo.model.TypeIntervention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeInterventionRepository extends JpaRepository<TypeIntervention, Integer> {

}
