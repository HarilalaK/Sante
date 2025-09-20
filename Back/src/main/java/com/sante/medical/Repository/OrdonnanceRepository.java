package com.sante.medical.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sante.medical.Model.Consultation;
import com.sante.medical.Model.Ordonnance;

import java.util.Optional;

@Repository
public interface OrdonnanceRepository extends JpaRepository<Ordonnance, Long> {
    // Méthode personnalisée pour trouver une ordonnance par consultation
    Optional<Ordonnance> findByConsultation(Consultation consultation);
}
