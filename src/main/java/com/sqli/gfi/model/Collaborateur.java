/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqli.gfi.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author karim
 */
@Entity
@Table(name = "collaborateur")
@PrimaryKeyJoinColumn(name = "id_u")
public class Collaborateur extends Utilisateur implements Serializable{

	private static final long serialVersionUID = 5165L;
		
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "session")
    private Set<Inscription> inscriptions = new HashSet<Inscription>(0);
	
	
    public Set<Inscription> getInscriptions() {
		return inscriptions;
	}

	public void setInscriptions(Set<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

	public Collaborateur() {
    }
    
    public Collaborateur(Integer id_u,String nom, String prenom) {
        super(id_u, nom, prenom);
    }

    public Collaborateur(String nom, String prenom, String adresse, String email, String tel) {
        super(nom, prenom, adresse, email, tel);
    }

	public Collaborateur(String nom, String prenom, String adresse,
			String email, String tel, Profile profile) {
		super(nom, prenom, adresse, email, tel, profile);
		// TODO Auto-generated constructor stub
	} 
    
    
    
}
