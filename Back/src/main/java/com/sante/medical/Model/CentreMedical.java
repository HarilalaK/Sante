package com.sante.medical.Model;

import java.util.Set;

import jakarta.persistence.*;

@Entity
public class CentreMedical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String adresse;
    private Double latitude;
    private Double longitude;

    @Enumerated(EnumType.STRING)
    private TypeCentre type; // HOPITAL, CLINIQUE, LABO, PHARMACIE

    @OneToMany(mappedBy = "centreMedical")
    private Set<Consultation> consultations;

    @OneToMany(mappedBy = "centreMedical")
    private Set<Examen> examens;

    // Getters et Setters
    
    
    public enum TypeCentre {
        HOPITAL, CLINIQUE, LABO, PHARMACIE
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public TypeCentre getType() {
		return type;
	}

	public void setType(TypeCentre type) {
		this.type = type;
	}

	public Set<Consultation> getConsultations() {
		return consultations;
	}

	public void setConsultations(Set<Consultation> consultations) {
		this.consultations = consultations;
	}

	public Set<Examen> getExamens() {
		return examens;
	}

	public void setExamens(Set<Examen> examens) {
		this.examens = examens;
	}
    
    
}
