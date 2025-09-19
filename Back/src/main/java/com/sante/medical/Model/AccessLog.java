package com.sante.medical.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AccessLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private User utilisateur;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Enumerated(EnumType.STRING)
    private Action action; // CONSULTATION, AJOUT, MODIFICATION

    private LocalDateTime dateAcces;

    // Getters et Setters
    
    
    public enum Action {
        CONSULTATION, AJOUT, MODIFICATION
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(User utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public LocalDateTime getDateAcces() {
		return dateAcces;
	}

	public void setDateAcces(LocalDateTime dateAcces) {
		this.dateAcces = dateAcces;
	}
    
    
}
