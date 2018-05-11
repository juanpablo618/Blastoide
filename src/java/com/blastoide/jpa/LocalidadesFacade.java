package com.blastoide.jpa;

import com.blastoide.jsf.Localidades;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cuello.juanpablo@gmail.com
 */
@Stateless
public class LocalidadesFacade extends AbstractFacade<Localidades> {

    @PersistenceContext(unitName = "BlastoidePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LocalidadesFacade() {
        super(Localidades.class);
    }
    
}
