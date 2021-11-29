package co.edu.unbosque.finalproject.controllers;

import co.edu.unbosque.finalproject.entities.Owner;
import co.edu.unbosque.finalproject.exceptions.OwnerNotFoundException;
import co.edu.unbosque.finalproject.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users/owners")
public class OwnerController {
    private final OwnerRepository ownerRepository;

    @Autowired
    public OwnerController(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @GetMapping
    public List<Owner> getOwners() {
        return ownerRepository.findAll();
    }

    @PostMapping
    public Owner createOwner(@RequestBody Owner owner) {
        return ownerRepository.save(owner);
    }

    @PutMapping("/{username}")
    public Owner updateOwner(@PathVariable String username, @RequestBody Owner owner) {
        return ownerRepository.findById(username).map(o -> {
            o.setEmail(owner.getEmail());
            o.setName(owner.getName());
            o.setAddress(owner.getAddress());
            o.setNeighborhood(owner.getNeighborhood());
            return ownerRepository.save(o);
        }).orElseThrow(() -> new OwnerNotFoundException(username));
    }

    @DeleteMapping("/{username}")
    public void deleteOwner(@PathVariable String username) {
        ownerRepository.deleteById(username);
    }
}
