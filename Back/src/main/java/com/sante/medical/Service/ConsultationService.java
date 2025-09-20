package com.sante.medical.Service;

import com.sante.medical.Model.Consultation;
import com.sante.medical.Model.Patient;
import com.sante.medical.Repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultationService {

    @Autowired
    private ConsultationRepository consultationRepository;

    // Créer une consultation
    public Consultation addConsultation(Consultation consultation) {
        consultation.setDateConsultation(LocalDateTime.now());
        return consultationRepository.save(consultation);
    }

    // Trouver une consultation par ID
    public Optional<Consultation> getConsultationById(Long id) {
        return consultationRepository.findById(id);
    }

    // Lister toutes les consultations
    public List<Consultation> getAllConsultations() {
        return consultationRepository.findAll();
    }

    // Mettre à jour une consultation
    public Consultation updateConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    // Supprimer une consultation
    public void deleteConsultation(Long id) {
        consultationRepository.deleteById(id);
    }

    // Trouver les consultations d'un patient
    public List<Consultation> getConsultationsByPatient(Patient patient) {
        return consultationRepository.findByPatient(patient);
    }
}
