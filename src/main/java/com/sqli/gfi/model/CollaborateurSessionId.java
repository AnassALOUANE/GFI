/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqli.gfi.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 *
 * @author karim
 */
@Embeddable
public class CollaborateurSessionId implements Serializable{
	
	private static final long serialVersionUID = 5165L;
    
    @ManyToOne
    private  Collaborateur collaborateur;
    @ManyToOne
    private SessionF session;

    public CollaborateurSessionId() {
    }
    

    public CollaborateurSessionId(Collaborateur collaborateur, SessionF session) {
		this.collaborateur = collaborateur;
		this.session = session;
	}


	public void setCollaborateur(Collaborateur collaborateur) {
        this.collaborateur = collaborateur;
    }

    public void setSession(SessionF session) {
        this.session = session;
    }

    public Collaborateur getCollaborateur() {
        return collaborateur;
    }

    public SessionF getSession() {
        return session;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.collaborateur);
        hash = 37 * hash + Objects.hashCode(this.session);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CollaborateurSessionId other = (CollaborateurSessionId) obj;
        if (!Objects.equals(this.collaborateur, other.collaborateur)) {
            return false;
        }
        if (!Objects.equals(this.session, other.session)) {
            return false;
        }
        return true;
    }
    
    
}
