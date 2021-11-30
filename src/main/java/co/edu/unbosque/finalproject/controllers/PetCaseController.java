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
@RequestMapping("/petCases")
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
    public List<PetCase> getPetCasesFromPets() {
        return petCaseRepository.findAll();
    }

}
