package co.edu.unbosque.finalproject.controllers;

import co.edu.unbosque.finalproject.entities.Vet;
import co.edu.unbosque.finalproject.exceptions.VetNotFoundException;
import co.edu.unbosque.finalproject.repositories.VetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users/vets")
public class VetController {
    private final VetRepository vetRepository;

    @Autowired
    public VetController(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @GetMapping
    public List<Vet> getVets() {
        return vetRepository.findAll();
    }

    @PostMapping
    public Vet createVet(@RequestBody Vet vet) {
        return vetRepository.save(vet);
    }

    @PutMapping("/{username}")
    public Vet updateVet(@PathVariable String username, @RequestBody Vet vet) {
        return vetRepository.findById(username).map(v -> {
            v.setEmail(vet.getEmail());
            v.setName(vet.getName());
            v.setAddress(vet.getAddress());
            v.setNeighborhood(vet.getNeighborhood());
            return vetRepository.save(vet);
        }).orElseThrow(() -> new VetNotFoundException(username));
    }

    @DeleteMapping("/{username}")
    public void deleteVet(@PathVariable String username) {
        vetRepository.deleteById(username);
    }
}
