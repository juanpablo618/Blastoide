package com.blastoide.jpa;

import com.blastoide.jsf.CuentaCorriente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cuello.juanpablo@gmail.com
 */
@Stateless
public class CuentaCorrienteFacade extends AbstractFacade<CuentaCorriente> {

    @PersistenceContext(unitName = "BlastoidePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CuentaCorrienteFacade() {
        super(CuentaCorriente.class);
    }
}