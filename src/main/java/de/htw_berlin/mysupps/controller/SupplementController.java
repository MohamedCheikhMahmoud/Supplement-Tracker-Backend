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
        supplement.setTaken(false);
        return supplementRepository.save(supplement);
    }

    @PutMapping("/supplements/{id}/toggle")
    public Supplement toggleTaken(@PathVariable Long id) {
        Supplement supplement = supplementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplement nicht gefunden"));

        supplement.setTaken(!supplement.isTaken());

        return supplementRepository.save(supplement);
    }
}
