package de.htw_berlin.mysupps.controller;

import de.htw_berlin.mysupps.model.Supplement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class SupplementController {

    @GetMapping
    public String test() {
        return "MySupps läuft!";
    }

    @GetMapping("/supplements")
    public List<Supplement> getAllSupplements() {

        return List.of(
                new Supplement("Vitamin D", "Vitamin", 1000, 30, "Morgens", "Täglich einnehmen"),
                new Supplement("Creatin", "Sport", 5, 50, "Nach dem Training", "Mit Wasser"),
                new Supplement("Omega 3", "Fettsäuren", 2, 40, "Abends", "Mit Mahlzeit"),
                new Supplement("Magnesium", "Mineralstoff", 400, 20, "Abends", "Vor dem Schlafen")
        );
    }

}
