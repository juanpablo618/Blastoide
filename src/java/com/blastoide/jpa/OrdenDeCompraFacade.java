/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blastoide.jpa;

import com.blastoide.jsf.OrdenDeCompra;
import com.blastoide.jsf.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author developer
 */
@Stateless
public class OrdenDeCompraFacade extends AbstractFacade<OrdenDeCompra> {

    @PersistenceContext(unitName = "BlastoidePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdenDeCompraFacade() {
        super(OrdenDeCompra.class);
    }
    
}
