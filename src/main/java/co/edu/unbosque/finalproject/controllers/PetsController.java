package co.edu.unbosque.finalproject.controllers;

import co.edu.unbosque.finalproject.entities.Owner;
import co.edu.unbosque.finalproject.entities.Pet;
import co.edu.unbosque.finalproject.repositories.OwnerRepository;
import co.edu.unbosque.finalproject.repositories.PetRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetsController {
    private final PetRepository petRepository;
    private final OwnerRepository ownerRepository;

    public PetsController(PetRepository petRepository, OwnerRepository ownerRepository) {
        this.petRepository = petRepository;
        this.ownerRepository = ownerRepository;
    }

    @GetMapping
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }
}
