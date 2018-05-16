package com.blastoide.jpa;

import com.blastoide.jsf.Depositos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cuello.juanpablo@gmail.com
 */
@Stateless
public class DepositosFacade extends AbstractFacade<Depositos> {

    @PersistenceContext(unitName = "BlastoidePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepositosFacade() {
        super(Depositos.class);
    }
    
}
