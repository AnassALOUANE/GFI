/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqli.gfi.model;

import java.io.Serializable;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author karim
 */
@Entity
@Table(name = "collaborateur_session")
@AssociationOverrides({
		@AssociationOverride(name = "pk.collaborateur", joinColumns = @JoinColumn(name = "id_collaborateur", referencedColumnName = "id_u")),
		@AssociationOverride(name = "pk.session", joinColumns = @JoinColumn(name = "id_session", referencedColumnName = "id_session")) })
public class CollaborateurSession implements Serializable {
	
	private static final long serialVersionUID = 5165L;

    @EmbeddedId
    private CollaborateurSessionId pk = new CollaborateurSessionId();
    
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE })
    @JoinColumn (name="id_eval")
    private Evaluation evaluation;
    
    public CollaborateurSession() {
    }
    
    

    public CollaborateurSession(CollaborateurSessionId pk) {
		this.pk = pk;
	}



	public void setPk(CollaborateurSessionId pk) {
        this.pk = pk;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }

    public CollaborateurSessionId getPk() {
        return pk;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }
    
    @Transient
    public Collaborateur getCollaborateur() {
        return getPk().getCollaborateur();
    }
    public void setCollaborateur(Collaborateur collaborateur) {
        getPk().setCollaborateur(collaborateur);
    }
    
    @Transient
    public SessionF getSession() {
        return getPk().getSession();
    }
    public void setSession(SessionF session) {
        getPk().setSession(session);
    }
}
