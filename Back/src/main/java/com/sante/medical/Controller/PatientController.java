package com.sante.medical.Controller;
import com.sante.medical.Model.Patient;
import com.sante.medical.Service.PatientService;
import com.sante.medical.Service.ConsultationService;
import com.sante.medical.Service.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private ConsultationService consultationService;
    @Autowired
    private ExamenService examenService;

    // Lister tous les patients (GET)
    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    // Récupérer un patient (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable Long id) {
        return patientService.getPatientById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Créer un patient (POST)
    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.createPatient(patient));
    }

    // Mettre à jour un patient (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePatient(@PathVariable Long id, @RequestBody Patient patientDetails) {
        return patientService.getPatientById(id)
                .map(patient -> {
                    patient.setDateNaissance(patientDetails.getDateNaissance());
                    patient.setSexe(patientDetails.getSexe());
                    patient.setGroupeSanguin(patientDetails.getGroupeSanguin());
                    Patient updatedPatient = patientService.createPatient(patient);
                    return ResponseEntity.ok(updatedPatient);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Supprimer un patient (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Long id) {
        return patientService.getPatientById(id)
                .map(patient -> {
                    patientService.deletePatient(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Historique médical (GET)
    @GetMapping("/{id}/historique")
    public ResponseEntity<?> getHistorique(@PathVariable Long id) {
        Optional<Patient> patientOptional = patientService.getPatientById(id);
        if (!patientOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Patient patient = patientOptional.get();
        Map<String, Object> historique = new HashMap<>();
        historique.put("patient", patient);
        historique.put("consultations", consultationService.getConsultationsByPatient(patient));
        historique.put("examens", examenService.getExamensByPatient(patient));
        return ResponseEntity.ok(historique);
    }

    // Générer un QR code (GET)
    @GetMapping("/{id}/qr")
    public ResponseEntity<String> generateQR(@PathVariable Long id) {
        return patientService.getPatientById(id)
                .map(patient -> ResponseEntity.ok(patientService.generateQRCode(patient)))
                .orElse(ResponseEntity.notFound().build());
    }
}
