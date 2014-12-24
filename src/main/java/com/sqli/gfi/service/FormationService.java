/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqli.gfi.service;

import com.sqli.gfi.model.Formation;
import java.util.List;

/**
 *
 * @author karim
 */
public interface FormationService {
    
    public void addFormation(Formation f);
    
    public List<Formation> getAllFormations();

    public Formation getFormationById(int idF);

    public void deleteFormation(int idF);
    
}
