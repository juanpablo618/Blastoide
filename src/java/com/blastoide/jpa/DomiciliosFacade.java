package com.blastoide.jpa;

import com.blastoide.jsf.Domicilios;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cuello.juanpablo@gmail.com
 */
@Stateless
public class DomiciliosFacade extends AbstractFacade<Domicilios> {

    @PersistenceContext(unitName = "BlastoidePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DomiciliosFacade() {
        super(Domicilios.class);
    }
    
}
