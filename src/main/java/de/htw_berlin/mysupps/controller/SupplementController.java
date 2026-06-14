package de.htw_berlin.mysupps.controller;

import de.htw_berlin.mysupps.model.Supplement;
import de.htw_berlin.mysupps.repository.SupplementRepository;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class SupplementController {

    private final SupplementRepository supplementRepository;

    public SupplementController(SupplementRepository supplementRepository) {
        this.supplementRepository = supplementRepository;
    }

    @GetMapping
    public String test() {
        return "MySupps läuft!";
    }

    @GetMapping("/supplements")
    public Iterable<Supplement> getAllSupplements() {
        return supplementRepository.findAll();
    }

    @PostMapping("/supplements")
    public Supplement createSupplement(@RequestBody Supplement supplement) {
        return supplementRepository.save(supplement);
    }
}
