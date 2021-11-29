package co.edu.unbosque.finalproject.repositories;

import co.edu.unbosque.finalproject.entities.PetCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetCaseRepository extends JpaRepository<PetCase, Long> {
    @Query("select p.petCases from Pet p, Owner o where p.petId = :petId and o.username = :username")
    List<PetCase> getPetCasesFromPet(@Param("petId") Long petId, @Param("username") String username);

    @Modifying
    @Query(value = "insert into pet_case(created_at, description, type) values (:createdAt, :description, :type))", nativeQuery = true)
    PetCase addPetCaseToPet();
}
