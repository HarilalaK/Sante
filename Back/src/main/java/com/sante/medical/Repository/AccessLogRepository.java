package com.sante.medical.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sante.medical.Model.AccessLog;
import com.sante.medical.Model.Patient;
import com.sante.medical.Model.User;

import java.util.List;

@Repository
public interface AccessLogRepository extends JpaRepository<AccessLog, Long> {
    // Méthode personnalisée pour trouver les logs d'un utilisateur
    List<AccessLog> findByUtilisateur(User utilisateur);

    // Méthode personnalisée pour trouver les logs d'un patient
    List<AccessLog> findByPatient(Patient patient);
}
