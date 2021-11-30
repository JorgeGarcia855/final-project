package co.edu.unbosque.finalproject.repositories;

import co.edu.unbosque.finalproject.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, String> {}
