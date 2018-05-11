package com.blastoide.jpa;

import com.blastoide.jsf.TiposEventualidad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cuello.juanpablo@gmail.com
 */
@Stateless
public class TiposEventualidadFacade extends AbstractFacade<TiposEventualidad> {

    @PersistenceContext(unitName = "BlastoidePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiposEventualidadFacade() {
        super(TiposEventualidad.class);
    }
    
}
