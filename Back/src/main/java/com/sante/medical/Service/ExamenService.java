package com.sante.medical.Service;
import com.sante.medical.Model.Examen;
import com.sante.medical.Model.Patient;
import com.sante.medical.Repository.ExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ExamenService {

    @Autowired
    private ExamenRepository examenRepository;

    // Créer un examen
    public Examen addExamen(Examen examen) {
        examen.setDateExamen(LocalDateTime.now());
        return examenRepository.save(examen);
    }

    // Trouver un examen par ID
    public Optional<Examen> getExamenById(Long id) {
        return examenRepository.findById(id);
    }

    // Lister tous les examens
    public List<Examen> getAllExamens() {
        return examenRepository.findAll();
    }

    // Mettre à jour un examen
    public Examen updateExamen(Examen examen) {
        return examenRepository.save(examen);
    }

    // Supprimer un examen
    public void deleteExamen(Long id) {
        examenRepository.deleteById(id);
    }

    // Trouver les examens d'un patient
    public List<Examen> getExamensByPatient(Patient patient) {
        return examenRepository.findByPatient(patient);
    }
}
