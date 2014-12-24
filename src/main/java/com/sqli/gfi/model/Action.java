/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqli.gfi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;


/**
 *
 * @author karim
 */
@Entity
@Table(name = "action")
public class Action implements Serializable {
    
	
	private static final long serialVersionUID = 5165L;
	
	
    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    @Column (name="id_action")
    private Integer id_action;
    
    @Column (name="libelle", length = 255)
    @NotEmpty(message="veuillez selectionner une action")
    private String libelle;
    
    @Column (name="[desc]", nullable = false)
    @NotEmpty(message="veuillez entrer une description ")
    private String desc;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name="id_profile")
    @Valid
    private Profile profile;

    public Action() {
    }

	public Action(Integer id_action, String libelle, String desc, Profile profile) {
		this.id_action = id_action;
		this.libelle = libelle;
		this.desc = desc;
		this.profile = profile;
	}

	public void setId_action(Integer id_action) {
        this.id_action = id_action;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Integer getId_action() {
        return id_action;
    }

    public String getLibelle() {
        return libelle;
    }
    
    public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Action [id_action=" + id_action + ", libelle=" + libelle
				+ ", desc=" + desc + " id_profile = "+profile.getId_profile()+"]";
	}
    
    
}
