package com.sante.medical.Service;

import com.sante.medical.Model.Patient;
import com.sante.medical.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    // Créer un patient
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    // Trouver un patient par ID
    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    // Trouver un patient par numéro de carte
    public Optional<Patient> getPatientByNumeroCarte(String numeroCarte) {
        return patientRepository.findByNumeroCartePatient(numeroCarte);
    }

    // Lister tous les patients
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Mettre à jour un patient
    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    // Supprimer un patient
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    // Générer un QR code (simulé)
    public String generateQRCode(Patient patient) {
        return "QR Code pour : " + patient.getNumeroCartePatient();
    }
}
