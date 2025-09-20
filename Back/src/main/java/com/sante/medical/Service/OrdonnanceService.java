package com.sante.medical.Service;

import com.sante.medical.Model.Ordonnance;
import com.sante.medical.Repository.OrdonnanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdonnanceService {

    @Autowired
    private OrdonnanceRepository ordonnanceRepository;

    // Créer une ordonnance
    public Ordonnance addOrdonnance(Ordonnance ordonnance) {
        return ordonnanceRepository.save(ordonnance);
    }

    // Trouver une ordonnance par ID
    public Optional<Ordonnance> getOrdonnanceById(Long id) {
        return ordonnanceRepository.findById(id);
    }

    // Lister toutes les ordonnances
    public List<Ordonnance> getAllOrdonnances() {
        return ordonnanceRepository.findAll();
    }

    // Mettre à jour une ordonnance
    public Ordonnance updateOrdonnance(Ordonnance ordonnance) {
        return ordonnanceRepository.save(ordonnance);
    }

    // Supprimer une ordonnance
    public void deleteOrdonnance(Long id) {
        ordonnanceRepository.deleteById(id);
    }
}
