package com.blastoide.jpa;

import com.blastoide.jsf.ClienteBueno;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cuello.juanpablo@gmail.com
 */
@Stateless
public class ClienteBuenoFacade extends AbstractFacade<ClienteBueno> {

    @PersistenceContext(unitName = "BlastoidePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteBuenoFacade() {
        super(ClienteBueno.class);
    }
    
}
