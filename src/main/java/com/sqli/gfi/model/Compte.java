/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqli.gfi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;




/**
 *
 * @author Anass
 */
@Entity
@Table(name = "compte")
//uniqueConstraints = @UniqueConstraint(columnNames = {"J_N", "J_K" })
public class Compte implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 5165L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_compte")
    private Integer id_compte;
    
    @Column (name="login", length = 100, unique=true, nullable=false)
    @NotEmpty(message="veuillez entrer votre login")
    private String login;
    
    @Column (name="password", length = 100)		
    @NotEmpty(message="veuillez entrer votre password")
    private String password;
    
    @Column (name="active")
    private Boolean active;
    
    @OneToOne(mappedBy="compte")
    private Utilisateur utilisateur;

    
//    
//    @Valid
//    private Profile profile;
   

	public Compte() {
	}
	
	
	
	public Compte(String login, String password, Boolean active) {
		this.login = login;
		this.password = password;
		this.active = active;
	}

	public Compte(String login, String password, Boolean active, Utilisateur utilisateur) {
		this.login = login;
		this.password = password;
		this.active = active;
		this.utilisateur = utilisateur;
	}

	public Compte(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Integer getId_compte() {
		return id_compte;
	}

	public void setId_compte(Integer id_compte) {
		this.id_compte = id_compte;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Compte [login=" + login + ", password=" + password
				+ ", active=" + active + "]";
	}
	
	
	
	

	
    
    
}
