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
@Table(name = "document")
public class Document implements Serializable {
	
	private static final long serialVersionUID = 5165L;
	
    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    @Column (name="id_doc")
    private Integer id_doc;
    
    @Column(name="nom")
    @NotEmpty(message="veuillez entrer le nom de document")
	private String nom;
    
    @Column (name="[desc]", nullable = false)
    private String desc;
    
    @Column(name="filename")
	private String filename;
    
//    @Column(name="contenu")
//	@Lob
//	private Blob contenu;
    
    @Column(name="contenu")
    private  byte[] contenu;
    
    @Column(name="TypeContenu")
	private String TypeContenu;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name="id_formation")
    private Formation formation;

    public Document() {
    }


	public Integer getId_doc() {
		return id_doc;
	}

	public void setId_doc(Integer id_doc) {
		this.id_doc = id_doc;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

//	public Blob getContenu() {
//		return contenu;
//	}
//
//	public void setContenu(Blob contenu) {
//		this.contenu = contenu;
//	}

	public String getTypeContenu() {
		return TypeContenu;
	}

	public void setTypeContenu(String typeContenu) {
		TypeContenu = typeContenu;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	
	

	public byte[] getContenu() {
		return contenu;
	}


	public void setContenu(byte[] contenu) {
		this.contenu = contenu;
	}


	@Override
	public String toString() {
		return "Document [nom=" + nom + ", desc=" + desc + ", filename="
				+ filename + ", TypeContenu=" + TypeContenu + ", formation="
				+ formation + "]";
	}
    
    

    
    
    
}
