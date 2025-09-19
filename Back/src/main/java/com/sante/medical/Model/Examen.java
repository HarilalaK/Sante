package com.sante.medical.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Examen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "centre_medical_id")
    private CentreMedical centreMedical;

    private String typeExamen;
    private String resultat;
    private LocalDateTime dateExamen;
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
	public CentreMedical getCentreMedical() {
		return centreMedical;
	}
	public void setCentreMedical(CentreMedical centreMedical) {
		this.centreMedical = centreMedical;
	}
	public String getTypeExamen() {
		return typeExamen;
	}
	public void setTypeExamen(String typeExamen) {
		this.typeExamen = typeExamen;
	}
	public String getResultat() {
		return resultat;
	}
	public void setResultat(String resultat) {
		this.resultat = resultat;
	}
	public LocalDateTime getDateExamen() {
		return dateExamen;
	}
	public void setDateExamen(LocalDateTime dateExamen) {
		this.dateExamen = dateExamen;
	}

    // Getters et Setters
    
}
