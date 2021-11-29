package co.edu.unbosque.finalproject.controllers;

import co.edu.unbosque.finalproject.entities.Official;
import co.edu.unbosque.finalproject.exceptions.OfficialNotFoundException;
import co.edu.unbosque.finalproject.repositories.OfficialRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users/officials")
public class OfficialController {
    private final OfficialRepository officialRepository;

    @Autowired
    public OfficialController(OfficialRepository officialRepository) {
        this.officialRepository = officialRepository;
    }

    @GetMapping
    public List<Official> getOfficials() {
        return officialRepository.findAll();
    }

    @PostMapping
    public Official createOfficial(@RequestBody Official official){
        return officialRepository.save(official);
    }

    @PutMapping("/{username}")
    public Official updateOfficial(@PathVariable String username, @RequestBody Official official) {
        return officialRepository.findById(username).map(o -> {
            o.setEmail(official.getEmail());
            o.setName(official.getName());
            return officialRepository.save(official);
        }).orElseThrow(() -> new OfficialNotFoundException(username));
    }

    @DeleteMapping("/{username}")
    public void deleteOfficial(@PathVariable String username) {
        officialRepository.deleteById(username);
    }
}
