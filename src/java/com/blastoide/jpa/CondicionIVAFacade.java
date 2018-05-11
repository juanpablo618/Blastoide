package com.blastoide.jpa;

import com.blastoide.jsf.CondicionIVA;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cuello.juanpablo@gmail.com
 */
@Stateless
public class CondicionIVAFacade extends AbstractFacade<CondicionIVA> {

    @PersistenceContext(unitName = "BlastoidePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CondicionIVAFacade() {
        super(CondicionIVA.class);
    }
}