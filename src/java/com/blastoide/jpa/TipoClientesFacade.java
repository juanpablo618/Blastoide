package com.blastoide.jpa;

import com.blastoide.jsf.TipoClientes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author developer
 */
@Stateless
public class TipoClientesFacade extends AbstractFacade<TipoClientes> {

    @PersistenceContext(unitName = "BlastoidePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoClientesFacade() {
        super(TipoClientes.class);
    }
    
}
