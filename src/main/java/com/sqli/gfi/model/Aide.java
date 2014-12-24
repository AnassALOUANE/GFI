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

/**
 *
 * @author karim
 */
@Entity
@Table(name = "aide")
public class Aide implements Serializable{
	
	private static final long serialVersionUID = 5165L;
    
    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    @Column (name="id_aide")
    private Integer id_aide;
    
    @Column (name="titre", length = 100)
    private String titre;
    
    @Column (name="contenu")
    private String contenu;

    public Aide() {
    }

    public Aide(String titre, String contenu) {
        this.titre = titre;
        this.contenu = contenu;
    }

    public void setId_aide(Integer id_aide) {
        this.id_aide = id_aide;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Integer getId_aide() {
        return id_aide;
    }

    public String getTitre() {
        return titre;
    }

    public String getContenu() {
        return contenu;
    }
    
    
}
