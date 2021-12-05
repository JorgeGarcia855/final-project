package co.edu.unbosque.finalproject.controllers;

import co.edu.unbosque.finalproject.entities.Pet;
import co.edu.unbosque.finalproject.entities.Vet;
import co.edu.unbosque.finalproject.entities.Visit;
import co.edu.unbosque.finalproject.exceptions.PetNotFoundException;
import co.edu.unbosque.finalproject.exceptions.VetNotFoundException;
import co.edu.unbosque.finalproject.repositories.PetRepository;
import co.edu.unbosque.finalproject.repositories.VetRepository;
import co.edu.unbosque.finalproject.repositories.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visits")
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

    @GetMapping
    public List<Visit> getVisits() {
        return visitRepository.findAll();
    }
    @PostMapping("/{username}/{petId}")
    public Visit createVisit(@RequestBody Visit visit, @PathVariable Long petId, @PathVariable String username) {
        Vet vet = vetRepository.findById(username).orElseThrow(() -> new VetNotFoundException(username));
        Pet pet = petRepository.findById(petId).orElseThrow(() -> new PetNotFoundException(petId));
        visit.setVet(vet);
        visit.setPet(pet);
        return visitRepository.save(visit);
    }

    @DeleteMapping("/{visitId}")
    public void deleteVisit(@PathVariable Long visitId) {
        visitRepository.deleteById(visitId);
    }
}
