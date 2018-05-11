package com.blastoide.jpa;

import com.blastoide.jsf.TiposProductos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cuello.juanpablo@gmail.com
 */
@Stateless
public class TiposProductosFacade extends AbstractFacade<TiposProductos> {

    @PersistenceContext(unitName = "BlastoidePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiposProductosFacade() {
        super(TiposProductos.class);
    }
    
}
