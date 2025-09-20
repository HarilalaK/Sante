package com.sante.medical.Controller;
import com.sante.medical.Model.Examen;
import com.sante.medical.Service.ExamenService;
import com.sante.medical.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/examens")
public class ExamenController {

    @Autowired
    private ExamenService examenService;
    @Autowired
    private PatientService patientService;

    // Lister tous les examens (GET)
    @GetMapping
    public ResponseEntity<List<Examen>> getAllExamens() {
        return ResponseEntity.ok(examenService.getAllExamens());
    }

    // Récupérer un examen (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Examen> getExamen(@PathVariable Long id) {
        return examenService.getExamenById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Créer un examen (POST)
    @PostMapping
    public ResponseEntity<Examen> createExamen(@RequestBody Examen examen) {
        return ResponseEntity.ok(examenService.addExamen(examen));
    }

    // Mettre à jour un examen (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<?> updateExamen(@PathVariable Long id, @RequestBody Examen examenDetails) {
        return examenService.getExamenById(id)
                .map(examen -> {
                    examen.setResultat(examenDetails.getResultat());
                    Examen updatedExamen = examenService.addExamen(examen);
                    return ResponseEntity.ok(updatedExamen);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Supprimer un examen (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExamen(@PathVariable Long id) {
        return examenService.getExamenById(id)
                .map(examen -> {
                    examenService.deleteExamen(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Examens d'un patient (GET)
    @GetMapping("/patient/{id}")
    public ResponseEntity<List<Examen>> getExamensByPatient(@PathVariable Long id) {
        return patientService.getPatientById(id)
                .map(patient -> ResponseEntity.ok(examenService.getExamensByPatient(patient)))
                .orElse(ResponseEntity.notFound().build());
    }
}
