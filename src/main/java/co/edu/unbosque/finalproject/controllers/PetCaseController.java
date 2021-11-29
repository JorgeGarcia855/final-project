package co.edu.unbosque.finalproject.controllers;

import co.edu.unbosque.finalproject.entities.Pet;
import co.edu.unbosque.finalproject.entities.PetCase;
import co.edu.unbosque.finalproject.repositories.OwnerRepository;
import co.edu.unbosque.finalproject.repositories.PetCaseRepository;
import co.edu.unbosque.finalproject.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/owners/{username}/pets/{petId}/petCases")
public class PetCaseController {
    private final PetCaseRepository petCaseRepository;
    private final PetRepository petRepository;
    private final OwnerRepository ownerRepository;

    @Autowired
    public PetCaseController(PetCaseRepository petCaseRepository, PetRepository petRepository, OwnerRepository ownerRepository) {
        this.petCaseRepository = petCaseRepository;
        this.petRepository = petRepository;
        this.ownerRepository = ownerRepository;
    }

    @GetMapping
    public List<PetCase> getPetCasesFromPets(@PathVariable Long petId, @PathVariable String username) {
        return petCaseRepository.findAll();
    }
//
//    @PostMapping
//    public PetCase addPetCaseToPet(@PathVariable Long petId, @PathVariable String username, @RequestBody PetCase petCase, @RequestBody Pet pet) {
//
//    }
}
