package com.sante.medical.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sante.medical.Model.Patient;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    // Méthode personnalisée pour trouver un patient par son numéro de carte
    Optional<Patient> findByNumeroCartePatient(String numeroCartePatient);
}
