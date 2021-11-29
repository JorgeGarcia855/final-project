package co.edu.unbosque.finalproject.repositories;

import co.edu.unbosque.finalproject.entities.Official;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficialRepository extends JpaRepository<Official, String> {
}
