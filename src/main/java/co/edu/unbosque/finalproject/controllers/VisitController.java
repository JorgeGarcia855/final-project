package co.edu.unbosque.finalproject.controllers;

import co.edu.unbosque.finalproject.entities.Owner;
import co.edu.unbosque.finalproject.entities.Pet;
import co.edu.unbosque.finalproject.entities.Visit;
import co.edu.unbosque.finalproject.exceptions.VetNotFoundException;
import co.edu.unbosque.finalproject.repositories.OwnerRepository;
import co.edu.unbosque.finalproject.repositories.PetRepository;
import co.edu.unbosque.finalproject.repositories.VetRepository;
import co.edu.unbosque.finalproject.repositories.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class VisitController {
    private final VisitRepository visitRepository;
    private final VetRepository vetRepository;
    private final PetRepository petRepository;
    private final OwnerRepository ownerRepository;
    @Autowired
    public VisitController(VisitRepository visitRepository, VetRepository vetRepository, PetRepository petRepository, OwnerRepository ownerRepository) {
        this.visitRepository = visitRepository;
        this.vetRepository = vetRepository;
        this.petRepository = petRepository;
        this.ownerRepository = ownerRepository;
    }


    @GetMapping("/users/owners/{username}/pets/{petId}/visits")
    public List<Visit> getVisitsFromPet(@PathVariable String username, @PathVariable Long petId) {
        Optional<Owner> owner = ownerRepository.findById(username);
        Optional<Pet> pet = petRepository.findById(petId);
        return vetRepository.findById(username).get().getVisits();
    }

    @GetMapping("/users/vets/{username}/visits")
    public List<Visit> getVisitsFromVet(@PathVariable String username) {
        return vetRepository.findById(username).get().getVisits();
    }

    @PostMapping(value = {"/users/vets/{username}/visits", "/users/owners/{username}/pets/{petId}/visits"})
    public Visit addVisitToOwner(@PathVariable String username, @RequestBody Visit visit) {
        return vetRepository.findById(username).map(vet -> {
            visit.setVet(vet);
            return visitRepository.save(visit);
        }).orElseThrow(() -> new VetNotFoundException(username));
    }
}
