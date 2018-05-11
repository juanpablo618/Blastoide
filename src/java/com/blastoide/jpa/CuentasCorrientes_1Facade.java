package com.blastoide.jpa;

import com.blastoide.jsf.CuentasCorrientes_1;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cuello.juanpablo@gmail.com
 */
@Stateless
public class CuentasCorrientes_1Facade extends AbstractFacade<CuentasCorrientes_1> {

    @PersistenceContext(unitName = "BlastoidePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CuentasCorrientes_1Facade() {
        super(CuentasCorrientes_1.class);
    }
    
}
