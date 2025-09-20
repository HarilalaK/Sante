package com.sante.medical.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sante.medical.Model.Consultation;
import com.sante.medical.Model.Patient;
import com.sante.medical.Model.User;

import java.util.List;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
    // Méthode personnalisée pour trouver les consultations d'un patient
    List<Consultation> findByPatient(Patient patient);

    // Méthode personnalisée pour trouver les consultations d'un médecin
    List<Consultation> findByMedecin(User medecin);
}

