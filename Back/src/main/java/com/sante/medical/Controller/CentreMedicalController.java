package com.sante.medical.Controller;
import com.sante.medical.Model.CentreMedical;
import com.sante.medical.Service.CentreMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/centres")
public class CentreMedicalController {

    @Autowired
    private CentreMedicalService centreMedicalService;

    // Lister tous les centres (GET)
    @GetMapping
    public ResponseEntity<List<CentreMedical>> getAllCentres() {
        return ResponseEntity.ok(centreMedicalService.getAllCentres());
    }

    // Récupérer un centre (GET)
    @GetMapping("/{id}")
    public ResponseEntity<CentreMedical> getCentre(@PathVariable Long id) {
        return centreMedicalService.getCentreById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Créer un centre (POST)
    @PostMapping
    public ResponseEntity<CentreMedical> createCentre(@RequestBody CentreMedical centre) {
        return ResponseEntity.ok(centreMedicalService.addCentre(centre));
    }

    // Mettre à jour un centre (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCentre(@PathVariable Long id, @RequestBody CentreMedical centreDetails) {
        return centreMedicalService.getCentreById(id)
                .map(centre -> {
                    centre.setNom(centreDetails.getNom());
                    centre.setAdresse(centreDetails.getAdresse());
                    CentreMedical updatedCentre = centreMedicalService.addCentre(centre);
                    return ResponseEntity.ok(updatedCentre);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Supprimer un centre (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCentre(@PathVariable Long id) {
        return centreMedicalService.getCentreById(id)
                .map(centre -> {
                    centreMedicalService.deleteCentre(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
