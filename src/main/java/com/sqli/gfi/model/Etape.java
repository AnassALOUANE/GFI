/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqli.gfi.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author karim
 */
@Entity
@Table(name = "etape_formation")
public class Etape implements Serializable {
	
	private static final long serialVersionUID = 5165L;
    
    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    @Column (name="id_etape")
    private Integer id_etape;
    
    @Column (name="libelle", length = 100, nullable = false)
    @NotEmpty(message="veuillez entrer le titre de l'étape de formation")
    private String libelle;
    
    @Column (name="[desc]", nullable = false)
    @NotEmpty(message="veuillez entrer la description de l'étape de formation")
    private String desc;
    
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE })
    @JoinColumn (name="id_formation")
    private Formation formation;

    public Etape() {
    }

    public Etape(String libelle, String desc, Formation formation) {
        this.libelle = libelle;
        this.desc = desc;
        this.formation = formation;
    }

    public void setId_etape(Integer id_etape) {
        this.id_etape = id_etape;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public Integer getId_etape() {
        return id_etape;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getDesc() {
        return desc;
    }

    public Formation getFormation() {
        return formation;
    }
    
    
}
