package com.blastoide.jpa;

import com.blastoide.jsf.TiposRubros;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cuello.juanpablo@gmail.com
 */
@Stateless
public class TiposRubrosFacade extends AbstractFacade<TiposRubros> {

    @PersistenceContext(unitName = "BlastoidePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiposRubrosFacade() {
        super(TiposRubros.class);
    }
    
}
