package com.blastoide.jpa;

import com.blastoide.jsf.Provincias;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cuello.juanpablo@gmail.com
 */
@Stateless
public class ProvinciasFacade extends AbstractFacade<Provincias> {

    @PersistenceContext(unitName = "BlastoidePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProvinciasFacade() {
        super(Provincias.class);
    }
    
}
