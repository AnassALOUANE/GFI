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

/**
 *
 * @author karim
 */
@Entity
@Table(name = "inscription")
public class Inscription implements Serializable {
	
	private static final long serialVersionUID = 5165L;
    
    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    @Column (name="id_insc")
    private Integer id_insc;
    
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn (name = "id_resp_formation", referencedColumnName = "id_u")
    private ResponsableFormation responsableFormation;
    
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn (name = "id_session")
    private SessionF session;
    
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn (name = "id_collaborateur", referencedColumnName="id_u")
    private Collaborateur collaborateur;
    
    @Column (name="confirmer", length = 10)
    private Boolean confirmer;

    public Inscription() {
    }

    public Inscription(ResponsableFormation responsableFormation, SessionF session, Collaborateur collaborateur, Boolean confirmer) {
        this.responsableFormation = responsableFormation;
        this.session = session;
        this.collaborateur = collaborateur;
        this.confirmer = confirmer;
    }

    public void setId_insc(Integer id_insc) {
        this.id_insc = id_insc;
    }

    public void setResponsableFormation(ResponsableFormation responsableFormation) {
        this.responsableFormation = responsableFormation;
    }

    public void setSession(SessionF session) {
        this.session = session;
    }

    public void setCollaborateur(Collaborateur collaborateur) {
        this.collaborateur = collaborateur;
    }

    public void setConfirmer(Boolean confirmer) {
        this.confirmer = confirmer;
    }

    public Integer getId_insc() {
        return id_insc;
    }

    public ResponsableFormation getResponsableFormation() {
        return responsableFormation;
    }

    public SessionF getSession() {
        return session;
    }

    public Collaborateur getCollaborateur() {
        return collaborateur;
    }

    public Boolean getConfirmer() {
        return confirmer;
    }

    @Override
    public String toString() {
        return "Inscription{" + "id_insc=" + id_insc + ", responsableFormation=" + responsableFormation + ", session=" + session + ", collaborateur=" + collaborateur + ", confirmer=" + confirmer + '}';
    }
    
    
    
    
}
