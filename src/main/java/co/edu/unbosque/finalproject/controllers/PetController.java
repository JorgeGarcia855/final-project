package co.edu.unbosque.finalproject.controllers;

import co.edu.unbosque.finalproject.entities.Pet;
import co.edu.unbosque.finalproject.exceptions.OwnerNotFoundException;
import co.edu.unbosque.finalproject.exceptions.PetNotFoundException;
import co.edu.unbosque.finalproject.repositories.OwnerRepository;
import co.edu.unbosque.finalproject.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/owners/{username}/pets")
public class PetController {
    private final PetRepository petRepository;
    private final OwnerRepository ownerRepository;

    @Autowired
    public PetController(PetRepository petRepository, OwnerRepository ownerRepository) {
        this.petRepository = petRepository;
        this.ownerRepository = ownerRepository;
    }

    @GetMapping
    public List<Pet> getPetsFromOwner(@PathVariable String username) {
        return ownerRepository.findById(username).orElseThrow(() -> new OwnerNotFoundException(username)).getPets();
    }

    @PostMapping
    public Pet addPetToOwner(@PathVariable String username, @RequestBody Pet pet) {
        return ownerRepository.findById(username).map(owner -> {
            pet.setOwner(owner);
            return petRepository.save(pet);
        }).orElseThrow(() -> new OwnerNotFoundException(username));
    }

    @PutMapping("/{petId}")
    public Pet updatePet(@PathVariable String username, @PathVariable Long petId, @RequestBody Pet pet) {
        if (!ownerRepository.existsById(username)) throw new OwnerNotFoundException(username);
        return petRepository.findById(petId).map(p -> {
            p.setMicrochip(pet.getMicrochip());
            p.setName(pet.getName());
            p.setSpecies(pet.getSpecies());
            p.setRace(pet.getRace());
            p.setSize(pet.getSize());
            p.setSex(pet.getSex());
            p.setPicture(pet.getPicture());
            return petRepository.save(p);
        }).orElseThrow(() -> new PetNotFoundException(petId));
    }
}
