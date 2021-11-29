package co.edu.unbosque.finalproject.repositories;

import co.edu.unbosque.finalproject.entities.PetCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetCaseRepository extends JpaRepository<PetCase, Long> {
}
