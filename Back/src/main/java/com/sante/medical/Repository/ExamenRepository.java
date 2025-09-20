package com.sante.medical.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sante.medical.Model.Examen;
import com.sante.medical.Model.Patient;

import java.util.List;

@Repository
public interface ExamenRepository extends JpaRepository<Examen, Long> {
    // Méthode personnalisée pour trouver les examens d'un patient
    List<Examen> findByPatient(Patient patient);

    // Méthode personnalisée pour trouver les examens par type
    List<Examen> findByTypeExamen(String typeExamen);
}
