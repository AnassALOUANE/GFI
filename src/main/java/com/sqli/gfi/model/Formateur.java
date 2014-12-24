/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqli.gfi.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author karim
 */
@Entity
@Table(name="formateur")
@PrimaryKeyJoinColumn(name="id_u")
public class Formateur extends Utilisateur {
	
	private static final long serialVersionUID = 5165L;
    
    @Column(name="niveau_etude", length = 100, nullable = false)
    @NotEmpty(message="vous devez choisir votre niveau d'étude")
    private String niveau_etude;
    
    @Column(name="experience", length = 300, nullable = false)
    @NotEmpty(message="vous devez entrer votre experience") 
    private String experience;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "formateur")
    private Set<SessionF> sessions = new HashSet<SessionF>(0);

    public Formateur() {
    }

    public Formateur(String nom, String prenom, String adresse, String email, String tel, String niveau_etude, String experience) {
        super(nom, prenom, adresse, email, tel);
        this.niveau_etude = niveau_etude;
        this.experience = experience;
    }

    public void setNiveau_etude(String niveau_etude) {
        this.niveau_etude = niveau_etude;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getNiveau_etude() {
        return niveau_etude;
    }

    public String getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return "Formateur{nom : " + super.getNom()+ "prenom : " + super.getPrenom()+"niveau_etude=" + niveau_etude + ", experience=" + experience + '}';
    }
    
    
    
}
