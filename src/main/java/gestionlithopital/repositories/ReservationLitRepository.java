package gestionlithopital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestionlithopital.entities.ReservationLit;

@Repository
public interface ReservationLitRepository extends JpaRepository<ReservationLit, Long> {

}
