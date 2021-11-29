package co.edu.unbosque.finalproject.controllers;

import co.edu.unbosque.finalproject.entities.Owner;
import co.edu.unbosque.finalproject.entities.Pet;
import co.edu.unbosque.finalproject.exceptions.OwnerNotFoundException;
import co.edu.unbosque.finalproject.exceptions.PetNotFoundException;
import co.edu.unbosque.finalproject.repositories.OwnerRepository;
import co.edu.unbosque.finalproject.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class PetController {
    private final PetRepository petRepository;
    private final OwnerRepository ownerRepository;

    @Autowired
    public PetController(PetRepository petRepository, OwnerRepository ownerRepository) {
        this.petRepository = petRepository;
        this.ownerRepository = ownerRepository;
    }

    @GetMapping("/owners/{username}/pets")
    public List<Pet> getPetsFromOwner(@PathVariable String username) {
        return ownerRepository.getById(username).getPets();
    }

    @PostMapping("/owners/{username}/pets")
    public Pet addPetToOwner(@PathVariable String username, @Valid @RequestBody Pet pet) {
        return ownerRepository.findById(username).map(owner -> {
            pet.setOwner(owner);
            return petRepository.save(pet);
        }).orElseThrow(() -> new OwnerNotFoundException(username));
    }

    @PutMapping("/owners/{username}/pets/{petId}")
    public Pet updatePet(@PathVariable String username, @PathVariable Long petId, @Valid @RequestBody Pet pet) {
        if (!ownerRepository.existsById(username)) throw new OwnerNotFoundException(username);
        return petRepository.findById(petId).map(p -> {
            p.setMicrochip(pet.getMicrochip());
            p.setName(pet.getName());
            p.setSpecies(pet.getSpecies());
            p.setRace(pet.getRace());
            p.setSize(pet.getSize());
            p.setSex(pet.getSex());
            p.setPicture(pet.getPicture());
            return petRepository.save(pet);
        }).orElseThrow(() -> new PetNotFoundException(petId));
    }
}
