package com.blastoide.jpa;

import com.blastoide.jsf.Eventualidades;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cuello.juanpablo@gmail.com
 */
@Stateless
public class EventualidadesFacade extends AbstractFacade<Eventualidades> {

    @PersistenceContext(unitName = "BlastoidePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EventualidadesFacade() {
        super(Eventualidades.class);
    }
    
}
