package com.sante.medical.Model;

import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String dateNaissance;
    private String sexe;
    private String groupeSanguin;
    private String numeroCartePatient = UUID.randomUUID().toString(); // Généré automatiquement

    @OneToMany(mappedBy = "patient")
    private Set<Consultation> consultations;

    @OneToMany(mappedBy = "patient")
    private Set<Examen> examens;

    @OneToMany(mappedBy = "patient")
    private Set<AccessLog> accessLogs;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getGroupeSanguin() {
		return groupeSanguin;
	}

	public void setGroupeSanguin(String groupeSanguin) {
		this.groupeSanguin = groupeSanguin;
	}

	public String getNumeroCartePatient() {
		return numeroCartePatient;
	}

	public void setNumeroCartePatient(String numeroCartePatient) {
		this.numeroCartePatient = numeroCartePatient;
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

	public Set<AccessLog> getAccessLogs() {
		return accessLogs;
	}

	public void setAccessLogs(Set<AccessLog> accessLogs) {
		this.accessLogs = accessLogs;
	}

    // Getters et Setters
    
}
