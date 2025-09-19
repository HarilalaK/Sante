package com.sante.medical.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "medecin_id")
    private User medecin;

    @ManyToOne
    @JoinColumn(name = "centre_medical_id")
    private CentreMedical centreMedical;

    private LocalDateTime dateConsultation;
    private String diagnostic;

    @OneToOne(mappedBy = "consultation", cascade = CascadeType.ALL)
    private Ordonnance ordonnance;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public User getMedecin() {
		return medecin;
	}

	public void setMedecin(User medecin) {
		this.medecin = medecin;
	}

	public CentreMedical getCentreMedical() {
		return centreMedical;
	}

	public void setCentreMedical(CentreMedical centreMedical) {
		this.centreMedical = centreMedical;
	}

	public LocalDateTime getDateConsultation() {
		return dateConsultation;
	}

	public void setDateConsultation(LocalDateTime dateConsultation) {
		this.dateConsultation = dateConsultation;
	}

	public String getDiagnostic() {
		return diagnostic;
	}

	public void setDiagnostic(String diagnostic) {
		this.diagnostic = diagnostic;
	}

	public Ordonnance getOrdonnance() {
		return ordonnance;
	}

	public void setOrdonnance(Ordonnance ordonnance) {
		this.ordonnance = ordonnance;
	}

    // Getters et Setters
    
}
