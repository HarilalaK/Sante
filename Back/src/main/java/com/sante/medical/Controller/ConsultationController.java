package com.sante.medical.Controller;
import com.sante.medical.Model.Consultation;
import com.sante.medical.Service.ConsultationService;
import com.sante.medical.Service.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/consultations")
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;
    
    @Autowired
    private PatientService patientService;

    // Lister toutes les consultations (GET)
    @GetMapping
    public ResponseEntity<List<Consultation>> getAllConsultations() {
        return ResponseEntity.ok(consultationService.getAllConsultations());
    }

    // Récupérer une consultation (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Consultation> getConsultation(@PathVariable Long id) {
        return consultationService.getConsultationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Créer une consultation (POST)
    @PostMapping
    public ResponseEntity<Consultation> createConsultation(@RequestBody Consultation consultation) {
        return ResponseEntity.ok(consultationService.addConsultation(consultation));
    }

    // Mettre à jour une consultation (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<?> updateConsultation(@PathVariable Long id, @RequestBody Consultation consultationDetails) {
        return consultationService.getConsultationById(id)
                .map(consultation -> {
                    consultation.setDiagnostic(consultationDetails.getDiagnostic());
                    Consultation updatedConsultation = consultationService.addConsultation(consultation);
                    return ResponseEntity.ok(updatedConsultation);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Supprimer une consultation (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteConsultation(@PathVariable Long id) {
        return consultationService.getConsultationById(id)
                .map(consultation -> {
                    consultationService.deleteConsultation(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Consultations d'un patient (GET)
    @GetMapping("/patient/{id}")
    public ResponseEntity<List<Consultation>> getConsultationsByPatient(@PathVariable Long id) {
        return patientService.getPatientById(id)
                .map(patient -> ResponseEntity.ok(consultationService.getConsultationsByPatient(patient)))
                .orElse(ResponseEntity.notFound().build());
    }
}
