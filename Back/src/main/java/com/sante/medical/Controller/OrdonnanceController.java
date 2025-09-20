package com.sante.medical.Controller;

import com.sante.medical.Model.Ordonnance;
import com.sante.medical.Service.OrdonnanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ordonnances")
public class OrdonnanceController {

    @Autowired
    private OrdonnanceService ordonnanceService;

    // Lister toutes les ordonnances (GET)
    @GetMapping
    public ResponseEntity<List<Ordonnance>> getAllOrdonnances() {
        return ResponseEntity.ok(ordonnanceService.getAllOrdonnances());
    }

    // Récupérer une ordonnance (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Ordonnance> getOrdonnance(@PathVariable Long id) {
        return ordonnanceService.getOrdonnanceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Créer une ordonnance (POST)
    @PostMapping
    public ResponseEntity<Ordonnance> createOrdonnance(@RequestBody Ordonnance ordonnance) {
        return ResponseEntity.ok(ordonnanceService.addOrdonnance(ordonnance));
    }

    // Mettre à jour une ordonnance (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrdonnance(@PathVariable Long id, @RequestBody Ordonnance ordonnanceDetails) {
        return ordonnanceService.getOrdonnanceById(id)
                .map(ordonnance -> {
                    ordonnance.setMedicament(ordonnanceDetails.getMedicament());
                    ordonnance.setPosologie(ordonnanceDetails.getPosologie());
                    Ordonnance updatedOrdonnance = ordonnanceService.addOrdonnance(ordonnance);
                    return ResponseEntity.ok(updatedOrdonnance);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Supprimer une ordonnance (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrdonnance(@PathVariable Long id) {
        return ordonnanceService.getOrdonnanceById(id)
                .map(ordonnance -> {
                    ordonnanceService.deleteOrdonnance(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
