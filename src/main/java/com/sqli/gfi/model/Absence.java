/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqli.gfi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author karim
 */
@Entity
@Table(name = "absence")
public class Absence implements Serializable{
    

	private static final long serialVersionUID = 5165L;

	@Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    @Column (name="id_abs")
    private Integer id_abs;
    
    @Column (name="cause")
    private String cause;
    
    @Column(name="date_abs", length = 60, nullable = false)
    private Date date_abs;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name="id_f")
    private Formateur formateur;
    
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE })
    @JoinColumns({
        @JoinColumn(name="id_session", referencedColumnName="id_session"),
        @JoinColumn(name="id_collaborateur", referencedColumnName="id_collaborateur")
    })
    private CollaborateurSession collaborateurSession;
    

    public Absence() {
    }

    public Absence(String cause, Date date_abs, Formateur formateur) {
        this.cause = cause;
        this.date_abs = date_abs;
        this.formateur = formateur;
    }

    public void setId_abs(Integer id_abs) {
        this.id_abs = id_abs;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public void setDate_abs(Date date_abs) {
        this.date_abs = date_abs;
    }

    public void setFormateur(Formateur formateur) {
        this.formateur = formateur;
    }

    public Integer getId_abs() {
        return id_abs;
    }

    public String getCause() {
        return cause;
    }

    public Date getDate_abs() {
        return date_abs;
    }

    public Formateur getFormateur() {
        return formateur;
    }

	public CollaborateurSession getCollaborateurSession() {
		return collaborateurSession;
	}

	public void setCollaborateurSession(CollaborateurSession collaborateurSession) {
		this.collaborateurSession = collaborateurSession;
	}
    
    
    
    
    
    
}
