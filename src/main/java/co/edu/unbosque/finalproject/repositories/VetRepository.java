package co.edu.unbosque.finalproject.repositories;

import co.edu.unbosque.finalproject.entities.Vet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetRepository extends JpaRepository<Vet, String> {}
