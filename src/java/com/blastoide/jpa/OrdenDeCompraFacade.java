package com.blastoide.jpa;

import com.blastoide.jsf.OrdenDeCompra;
import com.blastoide.jsf.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cuello.juanpablo@gmail.com
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
