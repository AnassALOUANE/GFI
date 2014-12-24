/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqli.gfi.model;

import java.io.Serializable;
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

import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author karim
 */
@Entity
@Table(name = "formation")
public class Formation implements Serializable {
	
	private static final long serialVersionUID = 5165L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_formation", nullable = false)
    private Integer id_formation;
    
    @Column (name="titre", nullable = false)
    @NotEmpty(message="veuillez entrer le titre de la formation")
    private String titre;
    
    @Column (name="[desc]", nullable = false)
    @NotEmpty(message="veuillez entrer la description de la formation")
    private String desc;
    
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE })
    @JoinColumn (name="id_u")
    private ResponsableFormation responsableFormation;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "formation")
    private Set<Etape> etapes = new HashSet<Etape>(0);
   
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "formation")
    private Set<Document> documents = new HashSet<Document>(0);

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "formation")
    private Set<SessionF> sessions = new HashSet<SessionF>(0);
    
    public Formation() {
    }

    public Formation(Integer id_formation, String titre, String desc, ResponsableFormation responsableFormation) {
        this.id_formation = id_formation;
        this.titre = titre;
        this.desc = desc;
        this.responsableFormation = responsableFormation;
    }

    public Formation(String titre, String desc, ResponsableFormation responsableFormation) {
		this.titre = titre;
		this.desc = desc;
		this.responsableFormation = responsableFormation;
	}

	public Integer getId_formation() {
		return id_formation;
	}

	public void setId_formation(Integer id_formation) {
		this.id_formation = id_formation;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public ResponsableFormation getResponsableFormation() {
		return responsableFormation;
	}

	public void setResponsableFormation(ResponsableFormation responsableFormation) {
		this.responsableFormation = responsableFormation;
	}

	public Set<Etape> getEtapes() {
		return etapes;
	}

	public void setEtapes(Set<Etape> etapes) {
		this.etapes = etapes;
	}

	public Set<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}

	public Set<SessionF> getSessions() {
		return sessions;
	}

	public void setSessions(Set<SessionF> sessions) {
		this.sessions = sessions;
	}

	@Override
	public String toString() {
		return "Formation [titre=" + titre + ", desc=" + desc
				+ ", responsableFormation=" + responsableFormation + "]";
	}

	
    
    
}
