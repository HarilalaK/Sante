package com.sante.medical.Service;
import com.sante.medical.Model.CentreMedical;
import com.sante.medical.Repository.CentreMedicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CentreMedicalService {

    @Autowired
    private CentreMedicalRepository centreMedicalRepository;

    // Créer un centre médical
    public CentreMedical addCentre(CentreMedical centre) {
        return centreMedicalRepository.save(centre);
    }

    // Trouver un centre par ID
    public Optional<CentreMedical> getCentreById(Long id) {
        return centreMedicalRepository.findById(id);
    }

    // Lister tous les centres
    public List<CentreMedical> getAllCentres() {
        return centreMedicalRepository.findAll();
    }

    // Mettre à jour un centre
    public CentreMedical updateCentre(CentreMedical centre) {
        return centreMedicalRepository.save(centre);
    }

    // Supprimer un centre
    public void deleteCentre(Long id) {
        centreMedicalRepository.deleteById(id);
    }
}
