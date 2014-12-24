/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqli.gfi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author karim
 */
@Entity
@Table(name = "session")
public class SessionF implements Serializable{
	
	private static final long serialVersionUID = 5165L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_session", nullable = false)
    private Integer id_session;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "date_debut", nullable = false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @NotNull 
    private Date date_debut;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "date_fin", nullable = false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @NotNull 
    private Date date_fin;
    
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE })
    @JoinColumn (name="id_formation")
    private Formation formation;
    
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE })
    @JoinColumn (name="id_formateur")
    private Formateur formateur;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "session")
    private Set<Inscription> inscriptions = new HashSet<Inscription>(0);

    public SessionF() {
    }

    public SessionF(Date date_debut, Date date_fin, Formation formation) {
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.formation = formation;
    }
    

    public void setId_session(Integer id_session) {
        this.id_session = id_session;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public Integer getId_session() {
        return id_session;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public Formation getFormation() {
        return formation;
    }
    
    public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}
	
	public Set<Inscription> getInscriptions() {
		return inscriptions;
	}

	public void setInscriptions(Set<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

	@Override
    public String toString() {
        return "Session{" + "id_session=" + id_session + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", formation=" + formation + '}';
    }    
    
}
