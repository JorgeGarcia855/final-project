package co.edu.unbosque.finalproject.repositories;

import co.edu.unbosque.finalproject.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {}
