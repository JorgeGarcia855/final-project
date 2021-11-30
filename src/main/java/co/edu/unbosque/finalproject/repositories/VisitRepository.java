package co.edu.unbosque.finalproject.repositories;

import co.edu.unbosque.finalproject.entities.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {}
