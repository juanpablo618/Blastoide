/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blastoide.jsfcontroller;

import com.blastoide.jsf.ConfiguracionesGenerales;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author developer
 */
@Stateless
public class ConfiguracionesGeneralesFacade extends AbstractFacade<ConfiguracionesGenerales> {

    @PersistenceContext(unitName = "BlastoidePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConfiguracionesGeneralesFacade() {
        super(ConfiguracionesGenerales.class);
    }
    
}
