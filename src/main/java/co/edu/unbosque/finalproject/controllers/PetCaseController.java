package co.edu.unbosque.finalproject.controllers;

import co.edu.unbosque.finalproject.entities.Pet;
import co.edu.unbosque.finalproject.entities.PetCase;
import co.edu.unbosque.finalproject.exceptions.PetNotFoundException;
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

    @Autowired
    public PetCaseController(PetCaseRepository petCaseRepository, PetRepository petRepository) {
        this.petCaseRepository = petCaseRepository;
        this.petRepository = petRepository;
    }

    @GetMapping
    public List<PetCase> getPetCases() {
        return petCaseRepository.findAll();
    }

    @PostMapping("/{petId}")
    public PetCase createPetcase(@RequestBody PetCase petCase, @PathVariable Long petId) {
        Pet pet = petRepository.findById(petId).orElseThrow(() -> new PetNotFoundException(petId));
        petCase.setPet(pet);
        return petCaseRepository.save(petCase);
    }
}
