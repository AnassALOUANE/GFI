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
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author karim
 */
@Entity
@Table(name = "profile")
public class Profile implements Serializable{
	
	private static final long serialVersionUID = 5165L;
    
    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    @Column (name="id_profile")
    private Integer id_profile;
    
    @Column (name="titre", length = 100)
    @NotEmpty(message="vous devez entrer le titre du profile")
    private String titre;
    
//    @OneToMany(targetEntity = Action.class, cascade = {CascadeType.PERSIST,CascadeType.MERGE })
//    @JoinColumn(name = "id_profile")
//    private Set<Action> actions;
    

    public Profile() {
    }
    
    public Profile(Integer id_profile, String titre) {
		this.id_profile = id_profile;
		this.titre = titre;
    }

	public Profile(String titre) {
        this.titre = titre;
    }

    public void setId_profile(Integer id_profile) {
        this.id_profile = id_profile;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Integer getId_profile() {
        return id_profile;
    }

    public String getTitre() {
        return titre;
    }

//    public void setActions(Set<Action> actions) {
//        this.actions = actions;
//    }
//
//    public Set<Action> getActions() {
//        return actions;
//    }

	@Override
	public String toString() {
		return "Profile [id_profile=" + id_profile + ", titre=" + titre + "]";
	}
    
    
    
    
    
    
    
    
    
}
