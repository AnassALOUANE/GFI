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
@Table(name = "evaluation")
public class Evaluation implements Serializable{
	
	private static final long serialVersionUID = 5165L;
    
    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    @Column (name="id_eval")
    private Integer id_eval;
    
    @Column (name="libelle", length = 80, nullable = false)
    private String libelle;
    
    @Column (name="[desc]", nullable = false)
    private String desc;

    public Evaluation() {
    }

    public Evaluation(String libelle, String desc) {
        this.libelle = libelle;
        this.desc = desc;
    }

    public void setId_eval(Integer id_eval) {
        this.id_eval = id_eval;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getId_eval() {
        return id_eval;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getDesc() {
        return desc;
    }
    
    
}
