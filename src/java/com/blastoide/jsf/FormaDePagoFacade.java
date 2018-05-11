package com.blastoide.jsf;

import com.blastoide.jpa.FormaDePago;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cuello.juanpablo@gmail.com
 */
@Stateless
public class FormaDePagoFacade extends AbstractFacade<FormaDePago> {

    @PersistenceContext(unitName = "BlastoidePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FormaDePagoFacade() {
        super(FormaDePago.class);
    }
    
}