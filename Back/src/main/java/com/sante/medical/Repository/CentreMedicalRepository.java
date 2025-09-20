package com.sante.medical.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sante.medical.Model.CentreMedical;

import java.util.List;

@Repository
public interface CentreMedicalRepository extends JpaRepository<CentreMedical, Long> {
    // Méthode personnalisée pour trouver des centres par type
    List<CentreMedical> findByType(CentreMedical.TypeCentre type);
}

