package co.edu.unbosque.finalproject.controllers;

import co.edu.unbosque.finalproject.entities.Pet;
import co.edu.unbosque.finalproject.entities.Vet;
import co.edu.unbosque.finalproject.entities.Visit;
import co.edu.unbosque.finalproject.repositories.PetRepository;
import co.edu.unbosque.finalproject.repositories.VetRepository;
import co.edu.unbosque.finalproject.repositories.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/visits")
public class VisitController {
    private final VisitRepository visitRepository;
    private final VetRepository vetRepository;
    private final PetRepository petRepository;
    @Autowired
    public VisitController(VisitRepository visitRepository, VetRepository vetRepository, PetRepository petRepository) {
        this.visitRepository = visitRepository;
        this.vetRepository = vetRepository;
        this.petRepository = petRepository;
    }

    @PostMapping("/{username}/{petId}")
    public Visit createVisit(@RequestBody Visit visit, @PathVariable Long petId, @PathVariable String username) {
        Vet vet = vetRepository.findById(username).get();
        Pet pet = petRepository.findById(petId).get();
        visit.setVet(vet);
        visit.setPet(pet);
        return visitRepository.save(visit);
    }
}
